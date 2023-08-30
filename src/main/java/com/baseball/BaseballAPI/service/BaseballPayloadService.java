package com.baseball.BaseballAPI.service;

import com.baseball.BaseballAPI.payload.Season;
import com.baseball.BaseballAPI.payload.TeamStandings;
import com.fasterxml.jackson.databind.MapperFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BaseballPayloadService extends PayloadServiceImpl {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public BaseballPayloadService(){}

    public List<TeamStandings> getTeamStandings(String endpoint) {
        logger.info("Mapping list of objects payload to class: TeamStandings.class");
        Mono<Object[]> payload = getJsonArrayPayload(endpoint);
        Object[] objects = payload.block();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, TeamStandings.class))
                .collect(Collectors.toList());
    }

    public Season getSeason(String endpoint) {
        logger.info("Mapping object payload to class: Season.class");
        Mono<Object> payload = getJsonPayload(endpoint);
        Object object = payload.block();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper.convertValue(object, Season.class);
    }
}
