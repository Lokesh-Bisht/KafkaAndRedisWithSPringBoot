package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.controller;

import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.spotify.PlaylistDto;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class Playlist {

    @PostMapping("/spotify/playlist")
    public void createPlaylist(@RequestBody PlaylistDto playlistDto) {}

}
