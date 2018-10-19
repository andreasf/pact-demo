package com.example.pactconsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ZooApiClientConfig {
    private String baseUrl;

    public ZooApiClientConfig(Environment environment) {
        baseUrl = environment.getRequiredProperty("zoo.api.base.url");
    }

    @Bean
    public ZooApiClient zooApiClient() {
        return new ZooApiClient(baseUrl, new RestTemplate());
    }
}
