package dev.lokeshbisht.SongService.controller;

import dev.lokeshbisht.SongService.dto.genre.GenreDto;
import dev.lokeshbisht.SongService.dto.genre.GenreRequestDto;
import dev.lokeshbisht.SongService.entity.Genre;
import dev.lokeshbisht.SongService.mapper.GenreMapper;
import dev.lokeshbisht.SongService.repository.GenreRepository;
import dev.lokeshbisht.SongService.service.GenreService;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

@SpringBootTest
public class GenreControllerTest {

    @MockBean
    private GenreService genreService;

    @MockBean
    private GenreMapper genreMapper;

    public void createGenreTest() {
//        GenreRequestDto genreRequestDto = new GenreRequestDto();
//        genreRequestDto.setName("Alternate rock");
//        genreRequestDto.setCreatedBy("lokeshbisht@dev.com");
//        Mockito.when(genreService.addGenre(genreRequestDto)).thenReturn(genre);
//        assertEquals()
    }
}
