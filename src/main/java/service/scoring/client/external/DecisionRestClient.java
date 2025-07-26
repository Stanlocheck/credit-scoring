package service.scoring.client.external;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.scoring.dto.ScoringInfo;
import service.scoring.dto.ScoringResult;

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
