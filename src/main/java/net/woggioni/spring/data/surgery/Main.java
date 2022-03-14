package net.woggioni.spring.data.surgery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

public class Main {

    @SpringBootApplication
    @EnableConfigurationProperties
    @EnableAutoConfiguration
    @EnableScheduling
    @EnableAsync
    static class App {

    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(App.class);
        app.run(args);
    }
}
