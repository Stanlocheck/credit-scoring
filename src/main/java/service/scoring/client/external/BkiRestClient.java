package service.scoring.client.external;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.scoring.dto.UserInfo;
import service.scoring.dto.bki.BkiResult;

@Service
public class BkiRestClient {
    private final RestTemplate bkiServiceRestTemplate;

    private static final String LOAD_HISTORY_PATH = "/history";

    public BkiRestClient(@Qualifier("bkiServiceRestTemplate") RestTemplate restTemplate) {
        this.bkiServiceRestTemplate = restTemplate;
    }

    public ResponseEntity<BkiResult> loadCreditHistory(UserInfo userInfo) {
        return bkiServiceRestTemplate.postForEntity(LOAD_HISTORY_PATH, userInfo, BkiResult.class);
    }
}
