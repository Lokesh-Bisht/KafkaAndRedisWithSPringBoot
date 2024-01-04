package dev.lokeshbisht.SongService.controller;

import dev.lokeshbisht.SongService.dto.ApiResponseDto;
import dev.lokeshbisht.SongService.dto.genre.GenreDto;
import dev.lokeshbisht.SongService.dto.genre.GenreRequestDto;
import dev.lokeshbisht.SongService.entity.Genre;
import dev.lokeshbisht.SongService.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @PostMapping("/genre")
    public GenreDto addGenre(@RequestBody GenreRequestDto genreRequestDto) {
        return genreService.addGenre(genreRequestDto);
    }

    @PutMapping("/genre/{genreId}")
    public GenreDto updateGenre(@RequestBody GenreRequestDto genreRequestDto, Long genreId) {
        return genreService.updateGenre(genreRequestDto, genreId);
    }

    @GetMapping("/genre/{genreId}")
    public ApiResponseDto<GenreDto> findGenre(@PathVariable Long genreId) {
        return genreService.findGenre(genreId);
    }

    @GetMapping("/genre/all")
    public ApiResponseDto<List<GenreDto>> findAllGenres() {
        return genreService.findAllGenres();
    }
}
