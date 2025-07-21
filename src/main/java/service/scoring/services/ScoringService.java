package service.scoring.services;

import org.springframework.stereotype.Service;
import service.scoring.client.external.*;
import service.scoring.dto.*;
import service.scoring.dto.antifraud.AntifraudResult;
import service.scoring.dto.bki.BkiResult;
import service.scoring.dto.fssp.FsspCheckResponse;
import service.scoring.dto.mobile.MobileOperatorResponse;
import service.scoring.dto.pdn.PdnResponse;

@Service
public class ScoringService {

    private final AntifraudRestClient antifraudRestClient;
    private final BeelineRestClient beelineRestClient;
    private final BkiRestClient bkiRestClient;
    private final FsspRestClient fsspRestClient;
    private final PdnRestClient pdnRestClient;
    private final DecisionRestClient decisionRestClient;

    public ScoringService(AntifraudRestClient antifraudRestClient,
                          BeelineRestClient beelineRestClient,
                          BkiRestClient bkiRestClient,
                          FsspRestClient fsspRestClient,
                          PdnRestClient pdnRestClient,
                          DecisionRestClient decisionRestClient) {
        this.antifraudRestClient = antifraudRestClient;
        this.beelineRestClient = beelineRestClient;
        this.bkiRestClient = bkiRestClient;
        this.fsspRestClient = fsspRestClient;
        this.pdnRestClient = pdnRestClient;
        this.decisionRestClient = decisionRestClient;
    }

    public void fullScoring(CreditRequest creditRequest) {
        UserInfo userInfo = creditRequest.getUserInfo();
        String phoneNumber = userInfo.getPhoneNumber();

        MobileOperatorResponse mobileOperatorResponse = beelineRestClient.getScoring(phoneNumber).getBody();
        AntifraudResult antifraudResult = antifraudRestClient.startAntifraud(userInfo).getBody();
        BkiResult bkiResult = bkiRestClient.loadCreditHistory(userInfo).getBody();
        FsspCheckResponse fsspCheckResponse = fsspRestClient.checkDebt(userInfo).getBody();
        PdnResponse pdnResponse = pdnRestClient.calculatePdn(userInfo).getBody();

        ScoringInfo scoringInfo = new ScoringInfo();
        scoringInfo.setCreditRequest(creditRequest);
        scoringInfo.setAntifraudResult(antifraudResult);
        scoringInfo.setBkiResult(bkiResult);
        scoringInfo.setFsspCheckResponse(fsspCheckResponse);
        scoringInfo.setPdnResponse(pdnResponse);
        scoringInfo.setMobileOperatorResponse(mobileOperatorResponse);

        ScoringResult result = decisionRestClient
                .getDecision(scoringInfo)
                .getBody();
    }
}
