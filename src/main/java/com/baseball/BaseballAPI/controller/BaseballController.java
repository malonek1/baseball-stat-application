package com.baseball.BaseballAPI.controller;

import com.baseball.BaseballAPI.consumer.SeasonConsumerService;
import com.baseball.BaseballAPI.consumer.StandingsConsumerService;
import com.baseball.BaseballAPI.payload.Season;
import com.baseball.BaseballAPI.payload.TeamStandings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseballController {

    private String BASE_URL = "https://api.sportsdata.io/v3/mlb/scores/json/";
    @Value("${token}")
    private String accessToken;
    StandingsConsumerService standingsConsumer = new StandingsConsumerService();
    SeasonConsumerService seasonConsumer = new SeasonConsumerService();

    @GetMapping("/standings")
    public List<TeamStandings> standings() {
        return standingsConsumer.getTeamStandings(standingsConsumer.getJsonArrayPayload(BASE_URL + "Standings/2023?" + accessToken));
    }

    //TODO: Develop logic in BaseballConsumerService to get consume a regular json object (getJsonPayload)
//    @GetMapping("/season")
//    public List<Season> season() {
//        return seasonConsumer.getSeason(seasonConsumer.getJsonPayload(BASE_URL + "CurrentSeason?" + accessToken));
//    }
}
