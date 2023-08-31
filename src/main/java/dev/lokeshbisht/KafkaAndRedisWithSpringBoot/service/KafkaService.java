package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.service;

import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.spotify.PlaylistDto;

public interface KafkaService {

    void sendPlaylistForCreate(PlaylistDto playlistDto);
}
