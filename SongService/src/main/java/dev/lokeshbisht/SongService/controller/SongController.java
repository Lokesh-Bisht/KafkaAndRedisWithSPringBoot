package dev.lokeshbisht.SongService.controller;

import dev.lokeshbisht.SongService.dto.ApiResponseDto;
import dev.lokeshbisht.SongService.dto.song.request.SongPlayCountRequestDto;
import dev.lokeshbisht.SongService.dto.song.response.SongDto;
import dev.lokeshbisht.SongService.dto.song.request.SongRequestDto;
import dev.lokeshbisht.SongService.service.SongService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/v1")
public class SongController {

    @Autowired
    private SongService songService;

    @PostMapping("/song")
    public SongDto addSong(@Valid @RequestBody SongRequestDto songRequestDto, @RequestHeader("X-Genre-Id") Long genreId) {
        return songService.addSong(songRequestDto, genreId);
    }

    @PutMapping("/song/{songId}")
    public SongDto updateSong(@Valid @RequestBody SongRequestDto songRequestDto, @RequestHeader("X-Genre-Id") Long genreId,
                              @PathVariable Long songId) {
        return songService.updateSong(songRequestDto, genreId, songId);
    }

    @PatchMapping("/song/{songId}/play")
    public SongDto updatePlayCount(@RequestBody SongPlayCountRequestDto songPlayCountRequestDto, @PathVariable Long songId) {
        return songService.updatePlayCount(songPlayCountRequestDto, songId);
    }

    @DeleteMapping("/song/{songId}")
    public void deleteSong(@PathVariable Long songId) {
        songService.deleteSong(songId);
    }

    @GetMapping("/song/{songId}")
    public ApiResponseDto<SongDto> getSong(@PathVariable Long songId) {
        return songService.getSong(songId);
    }
}
