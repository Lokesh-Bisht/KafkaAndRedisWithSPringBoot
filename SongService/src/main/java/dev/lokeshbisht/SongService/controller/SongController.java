package dev.lokeshbisht.SongService.controller;

import dev.lokeshbisht.SongService.dto.song.response.SongDto;
import dev.lokeshbisht.SongService.dto.song.request.SongRequestDto;
import dev.lokeshbisht.SongService.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping("/song")
    public SongDto addSong(@RequestBody SongRequestDto songRequestDto, @RequestHeader("X-Genre-Id") Long genredId) {
        return songService.addSong(songRequestDto, genredId);
    }
}
