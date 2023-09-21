package com.baseball.BaseballAPI.config;

import com.baseball.BaseballAPI.service.BaseballConsumerService;
import com.baseball.BaseballAPI.service.BaseballConsumerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class BaseballConfig {

    private WebClient.Builder webClient;
    private String accessToken;
    private String BASE_URL;

    @Autowired
    public BaseballConfig(@Value("${token}") String accessToken, @Value("${BASE_URL}") String BASE_URL) {
        this.webClient = WebClient.builder();
        this.accessToken = accessToken;
        this.BASE_URL = BASE_URL;
    }

    @Bean
    public BaseballConsumerService baseballConsumerService() {
        return new BaseballConsumerServiceImpl(accessToken, BASE_URL, webClient);
    }
}
