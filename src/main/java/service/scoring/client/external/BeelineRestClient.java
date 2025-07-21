package service.scoring.client.external;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import service.scoring.dto.mobile.MobileOperatorResponse;

import java.net.URI;
import java.util.Map;

@Service
public class BeelineRestClient {
    private final RestTemplate beelineServiceRestTemplate;

    private static final String GET_SCORE_PATH = "/score?phone={phone}";

    public BeelineRestClient(@Qualifier("beelineServiceRestTemplate") RestTemplate restTemplate) {
        this.beelineServiceRestTemplate = restTemplate;
    }

    public ResponseEntity<MobileOperatorResponse> getScoring(String phone) {
        return beelineServiceRestTemplate.postForEntity(GET_SCORE_PATH, null, MobileOperatorResponse.class, phone);
    }
}
