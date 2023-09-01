package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.service.impl;

import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.spotify.PlaylistDto;
import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.service.KafkaService;
import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.service.PlaylistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private KafkaService kafkaService;

    private static final Logger logger = LoggerFactory.getLogger(PlaylistServiceImpl.class);

    @Override
    public void createPlayList(PlaylistDto playlistDto) {
        logger.info("Start create playlist.");
        kafkaService.sendPlaylistForCreate(playlistDto);
    }
}
