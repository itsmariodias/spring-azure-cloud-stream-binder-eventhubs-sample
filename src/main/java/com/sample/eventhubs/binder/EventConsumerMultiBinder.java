package com.sample.eventhubs.binder;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@RequiredArgsConstructor
@Configuration
@Profile({"multi-binder", "multi-binder-mi-auth", "multi-binder-sp-auth"})
public class EventConsumerMultiBinder {

    private final EventPublisherMultiBinder eventPublisherMultiBinder;

    @Bean
    public Consumer<String> consumeGrass() {
        return pokemon -> {
            log.info("Received grass type : {}", pokemon);
            eventPublisherMultiBinder.publishEventFire("Charmander");
        };
    }

    @Bean
    public Consumer<String> consumeFire() {
        return pokemon -> {
            log.info("Received fire type : {}", pokemon);
            eventPublisherMultiBinder.publishEventWater("Squirtle");
        };
    }

    @Bean
    public Consumer<String> consumeWater() {
        return pokemon -> {
            log.info("Received water type : {}", pokemon);
        };
    }

    @ServiceActivator(inputChannel = "bulbasaur.$Default.errors")
    public void consumerError(Message<?> message) {
        log.error("Handling consumer ERROR: " + message);
    }

    @ServiceActivator(inputChannel = "charmander.$Default.errors")
    public void consumer2Error(Message<?> message) {
        log.error("Handling consumer ERROR: " + message);
    }

    @ServiceActivator(inputChannel = "squirtle.$Default.errors")
    public void consumer3Error(Message<?> message) {
        log.error("Handling consumer ERROR: " + message);
    }

}
