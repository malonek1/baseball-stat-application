package com.baseball.BaseballAPI.controller;

import com.baseball.BaseballAPI.service.BaseballPayloadService;
import com.baseball.BaseballAPI.payload.Season;
import com.baseball.BaseballAPI.payload.TeamStandings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseballController {
    @Autowired
    BaseballPayloadService baseballService;

    @GetMapping("/standings")
    public List<TeamStandings> standings() {
        return baseballService.getTeamStandings("Standings/2023?");
    }

    @GetMapping("/season")
    public Season season() {
        return baseballService.getSeason("CurrentSeason?");
    }
}
