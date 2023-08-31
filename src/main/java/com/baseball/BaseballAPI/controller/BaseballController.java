package com.baseball.BaseballAPI.controller;

import com.baseball.BaseballAPI.handler.BaseballHandler;
import com.baseball.BaseballAPI.entity.Season;
import com.baseball.BaseballAPI.entity.TeamStandings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseballController {
    @Autowired
    BaseballHandler baseballHandler;

    @GetMapping("/standings")
    public List<TeamStandings> standings() {
        return baseballHandler.getTeamStandings("Standings/2023?");
    }

    @GetMapping("/season")
    public Season season() {
        return baseballHandler.getSeason("CurrentSeason?");
    }
}
