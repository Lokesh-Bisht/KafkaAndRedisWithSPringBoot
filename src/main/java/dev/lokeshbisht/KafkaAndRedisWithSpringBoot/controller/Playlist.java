/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

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
