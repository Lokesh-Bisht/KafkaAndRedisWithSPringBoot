package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.consumers;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.request.CreateSongRequestDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.client.RestTemplate;

public class SongConsumer {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Value("${kafka.topic.song}")
    private String songTopic;

    @Value("${kafka.service.baser-url}")
    private String songServiceBaseUrl;

    private static final Logger logger = LoggerFactory.getLogger(SongConsumer.class);

    @KafkaListener(topics = "${songTopic}", groupId = "song")
    public void listenToSongTopic(@Payload String message,
                                  @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                                  @Header(KafkaHeaders.OFFSET) long offset,
                                  @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                                  @Header(KafkaHeaders.RECORD_METADATA) Object metadata
    ) {
        logger.info("Consuming message from topic {} with partition {}, offset {}, timestamp: {}, and metadata: {}", songTopic, partition, offset, timestamp, metadata);
        logger.info("Consumed message: " + message);
        String url = songServiceBaseUrl + "/v1/song";
        try {
            HttpHeaders headers = new HttpHeaders();
            CreateSongRequestDto createSongRequestDto = objectMapper.readValue(message, CreateSongRequestDto.class);
            headers.setContentType(MediaType.APPLICATION_JSON);
            restTemplate.exchange(url, HttpMethod.POST, new HttpEntity<>(createSongRequestDto, headers), new ParameterizedTypeReference<>() {
            });
        } catch (Exception ex) {
            logger.error("An error has occurred while calling POST {}", url);
            logger.error("Exception: {}", ex.getMessage());
        }
    }
}
