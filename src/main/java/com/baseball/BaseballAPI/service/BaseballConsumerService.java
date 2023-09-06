package com.baseball.BaseballAPI.service;

public interface BaseballConsumerService {
    Object getJsonPayload(String url);
    Object[] getJsonArrayPayload(String url);
}
