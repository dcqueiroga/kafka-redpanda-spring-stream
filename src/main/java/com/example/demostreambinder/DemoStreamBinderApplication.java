package com.example.demostreambinder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DemoStreamBinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoStreamBinderApplication.class, args);
    }

}
