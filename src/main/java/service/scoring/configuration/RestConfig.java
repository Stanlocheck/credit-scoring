package service.scoring.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;

@Configuration
public class RestConfig {

    @Bean
    public RestTemplate fsspServiceRestTemplate(@Value("${services.fssp.url}") String url, RestTemplateBuilder builder) {
        return builder
                .rootUri(url)
                .requestFactory(SimpleClientHttpRequestFactory::new)
                .build();
    }

    @Bean
    public RestTemplate bkiServiceRestTemplate(@Value("${services.bki.url}") String url, RestTemplateBuilder builder) {
        return builder
                .rootUri(url)
                .requestFactory(SimpleClientHttpRequestFactory::new)
                .build();
    }

    @Bean
    public RestTemplate beelineServiceRestTemplate(@Value("${services.beeline.url}") String url, RestTemplateBuilder builder) {
        return builder
                .rootUri(url)
                .requestFactory(SimpleClientHttpRequestFactory::new)
                .build();
    }

    @Bean
    public RestTemplate pdnServiceRestTemplate(@Value("${services.pdn.url}") String url, RestTemplateBuilder builder) {
        return builder
                .rootUri(url)
                .requestFactory(SimpleClientHttpRequestFactory::new)
                .build();
    }

    @Bean
    public RestTemplate antifraudServiceRestTemplate(@Value("${services.antifraud.url}") String url, RestTemplateBuilder builder) {
        return builder
                .rootUri(url)
                .requestFactory(SimpleClientHttpRequestFactory::new)
                .build();
    }

    @Bean
    public RestTemplate decisionServiceRestTemplate(@Value("${services.decision.url}") String url, RestTemplateBuilder builder) {
        return builder
                .rootUri(url)
                .requestFactory(SimpleClientHttpRequestFactory::new)
                .build();
    }
}
