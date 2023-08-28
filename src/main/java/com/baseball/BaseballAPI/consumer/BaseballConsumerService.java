package com.baseball.BaseballAPI.consumer;

import com.baseball.BaseballAPI.payload.TeamStandings;
import com.fasterxml.jackson.databind.MapperFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballConsumerService implements ConsumerService {

    private final WebClient.Builder webClient;

    @Autowired
    public BaseballConsumerService() {
        this.webClient = WebClient.builder();
    }

    @Override
    public Mono<Object[]> getObjectPayload(String url) {
        Mono<Object[]> payload = webClient.baseUrl(url).build().get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object[].class).log();
        return payload;
    }

    public List<TeamStandings> getTeamStandings(Mono<Object[]> payload) {
        Object[] objects = payload.block();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, TeamStandings.class))
                .collect(Collectors.toList());
    }
}
