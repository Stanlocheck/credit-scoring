package service.scoring.client.external;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.scoring.dto.CreditRequest;
import service.scoring.dto.ScoringInfo;
import service.scoring.dto.ScoringResult;
import service.scoring.dto.UserInfo;
import service.scoring.dto.antifraud.AntifraudResult;
import service.scoring.dto.bki.BkiResult;
import service.scoring.dto.fssp.FsspCheckResponse;
import service.scoring.dto.mobile.MobileOperatorResponse;
import service.scoring.dto.pdn.PdnResponse;

@Service
public class DecisionRestClient {
    private final RestTemplate decisionServiceRestTemplate;

    private static final String GET_DECISION_PATH = "/result";

    public DecisionRestClient(@Qualifier("decisionServiceRestTemplate") RestTemplate restTemplate) {
        this.decisionServiceRestTemplate = restTemplate;
    }

    public void getDecision(ScoringInfo scoringInfo) {
        decisionServiceRestTemplate.postForEntity(GET_DECISION_PATH, scoringInfo, ScoringResult.class);
    }
}
