package com.baseball.BaseballAPI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseballController {

    @Value("${token}")
    private String accessToken;
    @GetMapping("/token")
    public String token() {
        return accessToken;
    }
}
