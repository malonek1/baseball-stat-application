package com.baseball.BaseballAPI.controller;

import com.baseball.BaseballAPI.consumer.BaseballConsumerService;
import com.baseball.BaseballAPI.payload.TeamStandings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseballController {

    @Value("${token}")
    private String accessToken;
    BaseballConsumerService consumer = new BaseballConsumerService();

    @GetMapping("/standings")
    public List<TeamStandings> standings() {
        String url = "https://api.sportsdata.io/v3/mlb/scores/json/Standings/2023?" + accessToken;
        return consumer.getTeamStandings(consumer.getObjectPayload(url));
    }
}
