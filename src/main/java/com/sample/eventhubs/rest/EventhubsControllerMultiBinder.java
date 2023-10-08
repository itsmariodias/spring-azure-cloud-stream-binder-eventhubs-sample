package com.sample.eventhubs.rest;

import com.sample.eventhubs.binder.EventPublisherMultiBinder;
import com.sample.eventhubs.service.EventhubsServiceMultiBinder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequiredArgsConstructor
@Slf4j
@Profile({"multi-binder", "multi-binder-mi-auth", "multi-binder-sp-auth"})
public class EventhubsControllerMultiBinder {

    private final EventhubsServiceMultiBinder eventhubsServiceMultiBinder;

    private final EventPublisherMultiBinder eventPublisherMultiBinder;

    @PostMapping("/publishMessage")
    public Mono<ResponseEntity<String>> publishMessage() {
        return eventhubsServiceMultiBinder.someMethod()
                .publishOn(Schedulers.boundedElastic())
                .doOnSuccess(eventPublisherMultiBinder::publishEventGrass)
                .map(ResponseEntity::ok);
    }

}