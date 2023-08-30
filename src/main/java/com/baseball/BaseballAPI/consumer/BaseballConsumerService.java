package com.baseball.BaseballAPI.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class BaseballConsumerService implements ConsumerService {

    private final WebClient.Builder webClient;
    private String BASE_URL = "https://api.sportsdata.io/v3/mlb/scores/json/";
    @Value("${token}")
    private String accessToken;

    @Autowired
    public BaseballConsumerService() {
        this.webClient = WebClient.builder();
    }

    //A method that gets an object from json
    @Override
    public Mono<Object> getJsonPayload(String temp) {
        String url = BASE_URL + temp + accessToken;
        Mono<Object> payload = webClient.baseUrl(url).build().get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class).log();
        return payload;
    }

    //A method that gets an array of objects from a json array
    @Override
    public Mono<Object[]> getJsonArrayPayload(String temp) {
        String url = BASE_URL + temp + accessToken;
        Mono<Object[]> payload = webClient.baseUrl(url).build().get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object[].class).log();
        return payload;
    }
}
