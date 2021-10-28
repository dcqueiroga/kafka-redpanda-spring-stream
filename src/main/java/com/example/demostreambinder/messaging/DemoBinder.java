package com.example.demostreambinder.messaging;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;

public interface DemoBinder {
    String DEMO_IN = "demo-in";
    String DEMO_OUT = "demo-out";

    @Input(DEMO_IN)
    SubscribableChannel demoIn();

    @Output(DEMO_OUT)
    SubscribableChannel demoOut();
}
