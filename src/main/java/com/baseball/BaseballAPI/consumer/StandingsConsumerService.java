package com.baseball.BaseballAPI.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import reactor.core.publisher.Mono;

public interface StandingsConsumerService {

    final ObjectMapper mapper = new ObjectMapper();
    public Mono<Object[]> getObjectPayload();
}
