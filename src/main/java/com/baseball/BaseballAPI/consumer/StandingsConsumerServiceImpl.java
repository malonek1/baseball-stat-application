package com.baseball.BaseballAPI.consumer;

import com.baseball.BaseballAPI.pojo.TeamStandings;
import com.fasterxml.jackson.databind.MapperFeature;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StandingsConsumerServiceImpl implements StandingsConsumerService {

    private final WebClient webClient;

    public StandingsConsumerServiceImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Object[]> getObjectPayload() {
        Mono<Object[]> payload = webClient.get()
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
