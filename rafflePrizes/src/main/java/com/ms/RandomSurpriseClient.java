package com.ms;

import com.ms.model.Surprise;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomSurpriseClient {
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RandomSurpriseClient.class);

    private final RestTemplate restTemplate;

    private final CircuitBreakerFactory circuitBreakerFactory;


    public RandomSurpriseClient(RestTemplate restTemplate, CircuitBreakerFactory circuitBreakerFactory) {
        this.restTemplate = restTemplate;
        this.circuitBreakerFactory = circuitBreakerFactory;
    }


    public ResponseEntity<Surprise> random() {
        LOGGER.debug("Sending  request for Surprise {}");

        return circuitBreakerFactory.create("randomSurprise").run(
                () -> restTemplate.getForEntity("http://random-surprise/random", Surprise.class),
                throwable -> fallbackRandom());
    }

    public ResponseEntity<Surprise> fallbackRandom() {

        return ResponseEntity.ok().body(new Surprise("no surprise"));
    }
}
