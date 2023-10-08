package com.sample.eventhubs.binder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@Configuration
@Profile("single-binder")
public class EventConsumerSingleBinder {

    @Bean
    public Consumer<String> consume() {
        return message -> {
            log.info("Message received : {}", message);
        };
    }

    @ServiceActivator(inputChannel = "medium-eventhub.$Default.errors")
    public void consumerError(Message<?> message) {
        log.error("Handling consumer ERROR: " + message);
    }
}