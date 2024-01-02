package dev.lokeshbisht.SongService.mapper;

import dev.lokeshbisht.SongService.dto.genre.GenreDto;
import dev.lokeshbisht.SongService.dto.genre.GenreRequestDto;
import dev.lokeshbisht.SongService.entity.Genre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    Genre toGenre(GenreRequestDto genreRequestDto);
    GenreDto toGenreDto(Genre genre);
}
