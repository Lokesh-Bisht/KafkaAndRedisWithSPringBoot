package dev.lokeshbisht.SongService.service;

import dev.lokeshbisht.SongService.dto.song.request.SongRequestDto;
import dev.lokeshbisht.SongService.dto.song.response.SongDto;

public interface SongService {

    SongDto addSong(SongRequestDto songRequestDto, Long genreId);
    SongDto updateSong(SongRequestDto songRequestDto, Long genreId, Long songId);
}
