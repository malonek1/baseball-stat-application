package com.baseball.BaseballAPI.consumer;

import com.baseball.BaseballAPI.payload.Season;
import com.fasterxml.jackson.databind.MapperFeature;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class SeasonConsumerService extends BaseballConsumerService {

    private final WebClient.Builder webClient;

    public SeasonConsumerService() {
        this.webClient = WebClient.builder();
    }

    public Season getSeason(Mono<Object> payload) {
        Object object = payload.block();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper.convertValue(object, Season.class);
    }
}
