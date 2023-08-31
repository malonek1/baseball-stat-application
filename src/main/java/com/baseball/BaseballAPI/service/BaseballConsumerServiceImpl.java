package com.baseball.BaseballAPI.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


public class BaseballConsumerServiceImpl implements BaseballConsumerService {

    private String accessToken, BASE_URL;
    private WebClient.Builder webClient;
    private Logger logger;
    @Autowired
    public BaseballConsumerServiceImpl(String accessToken, String BASE_URL, WebClient.Builder webClient, Logger logger) {
        this.accessToken = accessToken;
        this.BASE_URL = BASE_URL;
        this.webClient = webClient;
        this.logger = logger;
    }

    //A method that gets an object from json
    @Override
    public Mono<Object> getJsonPayload(String endpoint) {
        String url = BASE_URL + endpoint + accessToken;
        logger.info("Creating object from json with url: {}", url);
        Mono<Object> payload = webClient
                .baseUrl(url)
                .build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class).log();
        return payload;
    }

    //A method that gets an array of objects from a json array
    @Override
    public Mono<Object[]> getJsonArrayPayload(String endpoint) {
        String url = BASE_URL + endpoint + accessToken;
        logger.info("Creating list of objects from json array with url: {}", url);
        Mono<Object[]> payload = webClient
                .baseUrl(url)
                .build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object[].class).log();
        return payload;
    }
}
