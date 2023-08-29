package com.baseball.BaseballAPI.consumer;

import com.baseball.BaseballAPI.payload.TeamStandings;
import com.fasterxml.jackson.databind.MapperFeature;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StandingsConsumerService extends BaseballConsumerService {

    public StandingsConsumerService(){}

    public List<TeamStandings> getTeamStandings(Mono<Object[]> payload) {
        Object[] objects = payload.block();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, TeamStandings.class))
                .collect(Collectors.toList());
    }
}
