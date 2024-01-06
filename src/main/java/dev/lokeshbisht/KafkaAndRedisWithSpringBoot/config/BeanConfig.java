package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class BeanConfig {

    @Bean
    @Primary
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder
            .setReadTimeout(Duration.ofSeconds(30))
            .setConnectTimeout(Duration.ofSeconds(30))
            .build();
    }
}
