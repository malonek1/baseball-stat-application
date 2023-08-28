package com.baseball.BaseballAPI.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class BaseballProperties {
    @Value("${token}")
    private String accessToken;

    public String getToken() {
        return accessToken;
    }

    @PostConstruct
    public void init() {
        System.out.println(accessToken);
    }
}
