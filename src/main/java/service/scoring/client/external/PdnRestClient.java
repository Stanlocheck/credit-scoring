package service.scoring.client.external;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.scoring.dto.UserInfo;
import service.scoring.dto.pdn.PdnResponse;

@Service
public class PdnRestClient {
    private final RestTemplate pdnServiceRestTemplate;

    private static final String CALCULATE_PDN_PATH = "/current";

    public PdnRestClient(@Qualifier("pdnServiceRestTemplate") RestTemplate restTemplate) {
        this.pdnServiceRestTemplate = restTemplate;
    }

    public ResponseEntity<PdnResponse> calculatePdn(UserInfo userInfo) {
        return pdnServiceRestTemplate.postForEntity(CALCULATE_PDN_PATH, userInfo, PdnResponse.class);
    }
}
