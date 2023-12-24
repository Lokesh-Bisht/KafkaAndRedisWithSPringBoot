/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.spotify")
    private String spotifyTopic;

    @Bean("spotify")
    public NewTopic spotifyTopic() {
        return TopicBuilder.name(spotifyTopic)
            .partitions(1)
            .replicas(1)
            .build();
    }
}
