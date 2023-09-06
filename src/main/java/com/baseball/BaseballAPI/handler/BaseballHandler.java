package com.baseball.BaseballAPI.handler;

import com.baseball.BaseballAPI.entity.Season;
import com.baseball.BaseballAPI.entity.TeamStandings;
import com.baseball.BaseballAPI.service.BaseballConsumerService;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class BaseballHandler {

    private BaseballConsumerService baseballConsumerService;
    private ObjectMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public BaseballHandler(BaseballConsumerService baseballConsumerService, ObjectMapper mapper){
        this.baseballConsumerService = baseballConsumerService;
        this.mapper = mapper;
    }

    public List<TeamStandings> getTeamStandings(String endpoint) {
        logger.info("Mapping list of objects payload to class: TeamStandings.class");
        Object[] objects = baseballConsumerService.getJsonArrayPayload(endpoint);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, TeamStandings.class))
                .collect(Collectors.toList());
    }

    public Season getSeason(String endpoint) {
        logger.info("Mapping object payload to class: Season.class");
        Object object = baseballConsumerService.getJsonPayload(endpoint);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper.convertValue(object, Season.class);
    }
}
