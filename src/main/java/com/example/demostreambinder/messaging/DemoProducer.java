package com.example.demostreambinder.messaging;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.IntStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class DemoProducer {

    private final DemoBinder demoBinder;

    @Value("${server.port:8080}")
    private int port;

    private int counter;

    @Scheduled(initialDelay = 5_000, fixedDelay = 5_000)
    public void producer() {
        if (port == 8080) {
            IntStream.range(0, 10)
                    .forEach(value -> {
                        var message = String.format("Message test of %s - %s", counter, value);
                        demoBinder.demoOut().send(MessageBuilder.withPayload(message).build());
                        log.info("Message produced: {}", message);
                    });
            counter++;
        }
    }
}
