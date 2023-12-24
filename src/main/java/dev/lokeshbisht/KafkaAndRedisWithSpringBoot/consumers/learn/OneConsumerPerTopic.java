package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.consumers.learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class OneConsumerPerTopic {

    @Value("${kafka.topic.artist}")
    private String artistTopic;

    private static final Logger logger = LoggerFactory.getLogger(OneConsumerPerTopic.class);

    @KafkaListener(topics = "${artistTopic}", groupId = "artist")
    public void listenToArtist(@Payload String message,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
                       @Header(KafkaHeaders.OFFSET) long offset,
                       @Header(KafkaHeaders.RECEIVED_TIMESTAMP) long timestamp,
                       @Header(KafkaHeaders.RECORD_METADATA) Object metadata
                       ) {
        logger.info("Consuming message from topic {} with partition {}, offset {}, timestamp: {}, and metadata: {}", artistTopic, partition, offset, timestamp, metadata);
        logger.info("Consumed message: " + message);
    }
}
