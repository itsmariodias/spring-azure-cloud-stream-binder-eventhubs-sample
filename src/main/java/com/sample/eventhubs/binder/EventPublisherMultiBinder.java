package com.sample.eventhubs.binder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
@Profile({"multi-binder", "multi-binder-mi-auth", "multi-binder-sp-auth"})
public class EventPublisherMultiBinder {

    private final StreamBridge streamBridge;

    public void publishEventGrass(String pokemon) {
        log.info("Sending grass type : {}", pokemon);
        streamBridge.send("supplyGrass-out-0", pokemon);
        log.info("Sent grass type {}.", pokemon);
    }

    public void publishEventFire(String pokemon) {
        log.info("Sending fire type : {}", pokemon);
        streamBridge.send("supplyFire-out-0", pokemon);
        log.info("Sent fire type : {}.", pokemon);
    }

    public void publishEventWater(String pokemon) {
        log.info("Sending water type : {}", pokemon);
        streamBridge.send("supplyWater-out-0", pokemon);
        log.info("Sent water type : {}.", pokemon);
    }

    @ServiceActivator(inputChannel = "bulbasaur.errors")
    public void producerError(Message<?> message) {
        log.error("Handling Producer ERROR: " + message);
    }

    @ServiceActivator(inputChannel = "charmander.errors")
    public void producer2Error(Message<?> message) {
        log.error("Handling Producer ERROR: " + message);
    }

    @ServiceActivator(inputChannel = "squirtle.errors")
    public void producer3Error(Message<?> message) {
        log.error("Handling Producer ERROR: " + message);
    }
}
