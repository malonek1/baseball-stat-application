package com.baseball.BaseballAPI.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Slf4j
public class BaseballConsumerServiceImpl implements BaseballConsumerService {

    private String accessToken, BASE_URL;
    private WebClient.Builder webClient;
    @Autowired
    public BaseballConsumerServiceImpl(String accessToken, String BASE_URL, WebClient.Builder webClient) {
        this.accessToken = accessToken;
        this.BASE_URL = BASE_URL;
        this.webClient = webClient;
    }

    //A method that gets an object from json
    @Override
    public Object getJsonPayload(String endpoint) {
        String url = BASE_URL + endpoint + accessToken;
        log.info("Creating object from json with url: {}", url);
        Object payload = webClient
                .baseUrl(url)
                .build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class)
                .log()
                .block();
        return payload;
    }

    //A method that gets an array of objects from a json array
    @Override
    public Object[] getJsonArrayPayload(String endpoint) {
        String url = BASE_URL + endpoint + accessToken;
        log.info("Creating list of objects from json array with url: {}", url);
        Object[] payload = webClient
                .baseUrl(url)
                .build()
                .get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object[].class)
                .log()
                .block();
        return payload;
    }
}
