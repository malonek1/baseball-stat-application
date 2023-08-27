package com.baseball.BaseballAPI.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


public class BaseballProperties {
    private String token;

    public String getToken() {
        return token;
    }
    @Autowired
    public void setToken(@Value("${token}") String token)
    {
        this.token = token;
    }
}
