package com.baseball.BaseballAPI;

import com.baseball.BaseballAPI.config.BaseballProperties;
import com.baseball.BaseballAPI.consumer.StandingsConsumerService;
import com.baseball.BaseballAPI.payload.TeamStandings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BaseballController {


    StandingsConsumerService standingsService = new StandingsConsumerService();

    @GetMapping("/standings")
    public List<TeamStandings> standings() {
        return standingsService.getTeamStandings(standingsService.getObjectPayload());
    }
}
