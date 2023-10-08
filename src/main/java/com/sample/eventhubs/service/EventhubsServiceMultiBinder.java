package com.sample.eventhubs.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
@Profile({"multi-binder", "multi-binder-mi-auth", "multi-binder-sp-auth"})
public class EventhubsServiceMultiBinder {

    public Mono<String> someMethod() {
        return Mono.just("Bulbasaur");
    }
}
