package com.baseball.BaseballAPI.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;

public interface BaseballConsumerService {
    Mono<Object> getJsonPayload(String url);
    Mono<Object[]> getJsonArrayPayload(String url);
}
