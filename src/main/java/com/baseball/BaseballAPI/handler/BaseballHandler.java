package com.baseball.BaseballAPI.handler;

import com.baseball.BaseballAPI.entity.Season;
import com.baseball.BaseballAPI.entity.TeamStandings;
import com.baseball.BaseballAPI.service.BaseballConsumerService;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Service
public class BaseballHandler {

    private BaseballConsumerService baseballConsumerService;
    private ObjectMapper mapper;

    @Autowired
    public BaseballHandler(BaseballConsumerService baseballConsumerService, ObjectMapper mapper){
        this.baseballConsumerService = baseballConsumerService;
        this.mapper = mapper;
    }

    public List<TeamStandings> getTeamStandings(String endpoint) {
        log.info("Mapping list of objects payload to class: TeamStandings.class");
        Object[] objects = baseballConsumerService.getJsonArrayPayload(endpoint);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, TeamStandings.class))
                .collect(Collectors.toList());
    }

    public Season getSeason(String endpoint) {
        log.info("Mapping object payload to class: Season.class");
        Object object = baseballConsumerService.getJsonPayload(endpoint);
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
        return mapper.convertValue(object, Season.class);
    }
}
