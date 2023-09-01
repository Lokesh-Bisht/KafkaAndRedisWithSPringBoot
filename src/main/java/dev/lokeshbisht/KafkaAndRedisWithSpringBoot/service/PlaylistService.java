package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.service;

import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.spotify.PlaylistDto;

public interface PlaylistService {

    void createPlayList(PlaylistDto playlistDto);
}
