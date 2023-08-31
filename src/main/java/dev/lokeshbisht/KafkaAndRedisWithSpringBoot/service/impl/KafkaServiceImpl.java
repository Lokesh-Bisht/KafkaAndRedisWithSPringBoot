package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.spotify.PlaylistDto;
import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.exceptions.JsonRuntimeException;
import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.service.KafkaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaServiceImpl implements KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${kafka.topic.playlistTopic}")
    private String playlistTopic;

    public static final Logger logger = LoggerFactory.getLogger(KafkaServiceImpl.class);

    private String getObjectAsJsonString(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new JsonRuntimeException("Json Processing Exception during object to string conversion", e);
        }
    }

    @Override
    public void sendPlaylistForCreate(PlaylistDto playlistDto) {
        logger.info("Push playlist dto to topic: {}, data: {}", playlistTopic, playlistDto);
        try {
            String data = getObjectAsJsonString(playlistDto);
            kafkaTemplate.send(playlistTopic, data);
            logger.info("Successfully pushed playlist dto: {} to kafka topic: {}", playlistDto, playlistTopic);
        } catch (Exception ex) {
            logger.error("An error occurred while pushing data to kafka topic. Error: {}", ex.getMessage());
        }
    }
}
