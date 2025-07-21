package service.scoring.client.external;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.scoring.dto.UserInfo;
import service.scoring.dto.antifraud.AntifraudResult;

@Service
public class AntifraudRestClient {
    private final RestTemplate antifraudServiceRestTemplate;

    private static final String START_ANTIFRAUD_PATH = "/check";

    public AntifraudRestClient(@Qualifier("antifraudServiceRestTemplate") RestTemplate restTemplate) {
        this.antifraudServiceRestTemplate = restTemplate;
    }

    public ResponseEntity<AntifraudResult> startAntifraud(UserInfo userInfo) {
        return antifraudServiceRestTemplate.postForEntity(START_ANTIFRAUD_PATH, userInfo, AntifraudResult.class);
    }
}
