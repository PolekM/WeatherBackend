package com.weather.components;


import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BeanInit {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
