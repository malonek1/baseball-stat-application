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

public class StandingsConsumerService implements ConsumerService {

    private final WebClient webClient;

    @Autowired
    public StandingsConsumerService() {
        String COMPLETE_URL = BASE_URL + "Standings/2023?key=bbac190de96f4dc4a9dbcea47854b0b2";
        this.webClient = WebClient.builder().baseUrl(COMPLETE_URL).build();
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
