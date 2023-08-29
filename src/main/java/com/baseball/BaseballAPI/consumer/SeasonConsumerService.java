package com.baseball.BaseballAPI.consumer;

import com.baseball.BaseballAPI.payload.Season;
import com.fasterxml.jackson.databind.MapperFeature;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SeasonConsumerService extends BaseballConsumerService{

    //TODO: Develop logic that takes the value gotten from a new object field based on getJsonPayload() method
//    public Season getSeason(Mono<Object> payload) {
//        Object objects = payload.block();
//        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
//        return Arrays.stream(objects)
//                .map(object -> mapper.convertValue(object, Season.class))
//                .collect(Collectors.toList());
//    }
}
