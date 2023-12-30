package dev.lokeshbisht.SongService.service;

import dev.lokeshbisht.SongService.dto.song.request.SongRequestDto;
import dev.lokeshbisht.SongService.dto.song.response.SongDto;

public interface SongService {

    public SongDto addSong(SongRequestDto songRequestDto, Long genreId);
}
