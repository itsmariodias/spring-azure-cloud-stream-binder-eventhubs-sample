package com.sample.eventhubs.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
@Profile("single-binder")
public class EventhubsServiceSingleBinder {

    public Mono<String> someMethod() {
        return Mono.just("Some string data");
    }
}
