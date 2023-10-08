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
@Profile("single-binder")
public class EventPublisherSingleBinder {

    private final StreamBridge streamBridge;

    public void publishEvent(String message) {
        log.info("Sending message: {}", message);
        streamBridge.send("supply-out-0", message);
        log.info("Sent {}.", message);
    }

    @ServiceActivator(inputChannel = "medium-eventhub.errors")
    public void producerError(Message<?> message) {
        log.error("Handling Producer ERROR: " + message);
    }
}
