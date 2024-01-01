package dev.lokeshbisht.SongService.controller;

import dev.lokeshbisht.SongService.dto.song.request.SongPlayCountRequestDto;
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
    public SongDto addSong(@RequestBody SongRequestDto songRequestDto, @RequestHeader("X-Genre-Id") Long genreId) {
        return songService.addSong(songRequestDto, genreId);
    }

    @PutMapping("/song/{songId}")
    public SongDto updateSong(@RequestBody SongRequestDto songRequestDto, @RequestHeader("X-Genre-Id") Long genreId,
                              @PathVariable Long songId) {
        return songService.updateSong(songRequestDto, genreId, songId);
    }

    @PatchMapping("/song/{songId}/play")
    public SongDto updatePlayCount(@RequestBody SongPlayCountRequestDto songPlayCountRequestDto, @PathVariable Long songId) {
        return songService.updatePlayCount(songPlayCountRequestDto, songId);
    }
}
