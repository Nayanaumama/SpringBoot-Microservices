package com.example.userservice.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class UserConfig {

    @Bean
    @LoadBalanced//this will make sure to use the name from the registry while calling the other service  instead of port
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
