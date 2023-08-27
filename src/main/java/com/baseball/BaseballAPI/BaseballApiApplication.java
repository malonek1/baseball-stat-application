package com.baseball.BaseballAPI;

import com.baseball.BaseballAPI.consumer.StandingsConsumerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class BaseballApiApplication {

//	private static BaseballService service = new BaseballService();

	public static void main(String[] args) {
		SpringApplication.run(BaseballApiApplication.class, args);

		StandingsConsumerService standings = new StandingsConsumerService();

		System.out.println(standings.getTeamStandings(standings.getObjectPayload()));

	}
}
