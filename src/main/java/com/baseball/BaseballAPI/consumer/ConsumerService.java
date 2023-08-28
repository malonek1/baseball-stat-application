package com.baseball.BaseballAPI.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;

public interface ConsumerService {
    final String BASE_URL = "https://api.sportsdata.io/v3/mlb/scores/json/";
    final ObjectMapper mapper = new ObjectMapper();
    public Mono<Object[]> getObjectPayload();
}
