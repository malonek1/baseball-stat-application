package com.baseball.BaseballAPI.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;

public interface ConsumerService {
    final ObjectMapper mapper = new ObjectMapper();
    public Mono<Object> getJsonPayload(String url);
    public Mono<Object[]> getJsonArrayPayload(String url);
}
