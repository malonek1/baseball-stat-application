package com.baseball.BaseballAPI.controller;

import com.baseball.BaseballAPI.consumer.SeasonConsumerService;
import com.baseball.BaseballAPI.consumer.StandingsConsumerService;
import com.baseball.BaseballAPI.payload.Season;
import com.baseball.BaseballAPI.payload.TeamStandings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class BaseballController {
    @Autowired
    StandingsConsumerService standingsConsumer;
    @Autowired
    SeasonConsumerService seasonConsumer;

    @GetMapping("/standings")
    public List<TeamStandings> standings() {
        return standingsConsumer.getTeamStandings(standingsConsumer.getJsonArrayPayload("Standings/2023?"));
    }

    @GetMapping("/season")
    public Season season() {
        return seasonConsumer.getSeason(seasonConsumer.getJsonPayload("CurrentSeason?"));
    }
}
