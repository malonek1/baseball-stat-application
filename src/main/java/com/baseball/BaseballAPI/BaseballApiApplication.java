package com.baseball.BaseballAPI;

import com.baseball.BaseballAPI.consumer.StandingsConsumerServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class BaseballApiApplication {

//	private static BaseballService service = new BaseballService();

	public static void main(String[] args) {
		SpringApplication.run(BaseballApiApplication.class, args);

		//String url = "http://lookup-service-prod.mlb.com/json/named.sport_career_hitting.bam?league_list_id='mlb'&game_type='R'&player_id='493316'";
		String url = "https://api.sportsdata.io/v3/mlb/scores/json/Standings/2023?key=bbac190de96f4dc4a9dbcea47854b0b2";
		//String url = "https://api.sportsdata.io/v3/mlb/scores/json/CurrentSeason?key=bbac190de96f4dc4a9dbcea47854b0b2";
		String catUrl = "https://catfact.ninja/fact?max_length=140";
		
		WebClient webClient = WebClient.builder().baseUrl(url).build();
		
		StandingsConsumerServiceImpl standings = new StandingsConsumerServiceImpl(webClient);

		System.out.println(standings.getTeamStandings(standings.getObjectPayload()));

	}
}
