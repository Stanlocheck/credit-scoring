package service.scoring.client.external;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.scoring.dto.UserInfo;
import service.scoring.dto.fssp.FsspCheckResponse;

@Service
public class FsspRestClient {
    private final RestTemplate fsspServiceRestTemplate;

    private static final String CHECK_DEBT_PATH = "/check";

    public FsspRestClient(@Qualifier("fsspServiceRestTemplate") RestTemplate restTemplate) {
        this.fsspServiceRestTemplate = restTemplate;
    }

    public ResponseEntity<FsspCheckResponse> checkDebt(UserInfo userInfo) {
        return fsspServiceRestTemplate.postForEntity(CHECK_DEBT_PATH, userInfo, FsspCheckResponse.class);
    }
}
