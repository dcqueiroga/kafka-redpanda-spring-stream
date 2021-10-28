package com.example.demostreambinder.messaging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableBinding(value = { DemoBinder.class })
public class DemoConsumer {

    @StreamListener(target = DemoBinder.DEMO_IN)
    public void consumer(@Payload String message) {
        try {
            Thread.sleep(200);
            log.info("Message consumed: {}", message);
        } catch (InterruptedException e) {
            log.error("Error executing DemoConsumer.consumer method");
        }
    }
}
