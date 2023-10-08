package com.sample.eventhubs.rest;

import com.sample.eventhubs.binder.EventPublisherSingleBinder;
import com.sample.eventhubs.service.EventhubsServiceSingleBinder;
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
@Profile("single-binder")
public class EventhubsControllerSingleBinder {

    private final EventhubsServiceSingleBinder eventhubsServiceSingleBinder;

    private final EventPublisherSingleBinder eventPublisherSingleBinder;

    @PostMapping("/publishMessage")
    public Mono<ResponseEntity<String>> publishMessage() {
        return eventhubsServiceSingleBinder.someMethod()
                .publishOn(Schedulers.boundedElastic())
                .doOnSuccess(eventPublisherSingleBinder::publishEvent)
                .map(ResponseEntity::ok);
    }

}
