package dev.lokeshbisht.SongService.service;

import dev.lokeshbisht.SongService.dto.ApiResponseDto;
import dev.lokeshbisht.SongService.dto.genre.GenreDto;
import dev.lokeshbisht.SongService.dto.genre.GenreRequestDto;

import java.util.List;

public interface GenreService {

    GenreDto addGenre(GenreRequestDto genreRequestDto);
    GenreDto updateGenre(GenreRequestDto genreRequestDto, Long genreId);
    ApiResponseDto<GenreDto> findGenre(Long genreId);
    ApiResponseDto<List<GenreDto>>findAllGenres();
}
