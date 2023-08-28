package com.baseball.BaseballAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BaseballApiApplication {

//	private static BaseballService service = new BaseballService();

	public static void main(String[] args) {
		SpringApplication.run(BaseballApiApplication.class, args);

//		StandingsConsumerService standings = new StandingsConsumerService();
//
//		System.out.println(standings.getTeamStandings(standings.getObjectPayload()));

	}
}
