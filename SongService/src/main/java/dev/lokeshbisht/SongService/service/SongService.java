package dev.lokeshbisht.service;

import dev.lokeshbisht.dto.song.response.SongDto;
import dev.lokeshbisht.dto.song.request.SongRequestDto;

public interface SongService {

    public SongDto addSong(SongRequestDto songRequestDto, Long genreId);
}
