package dev.lokeshbisht.SongService.service;

import dev.lokeshbisht.SongService.dto.genre.GenreDto;
import dev.lokeshbisht.SongService.dto.genre.GenreRequestDto;

public interface GenreService {

    GenreDto addGenre(GenreRequestDto genreRequestDto);
    GenreDto updateGenre(GenreRequestDto genreRequestDto, Long genreId);
    GenreDto findGenre(Long genreId);
}
