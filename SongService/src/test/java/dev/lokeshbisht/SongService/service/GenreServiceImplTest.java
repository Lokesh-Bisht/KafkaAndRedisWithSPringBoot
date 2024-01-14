package dev.lokeshbisht.SongService.service;

import dev.lokeshbisht.SongService.dto.genre.GenreDto;
import dev.lokeshbisht.SongService.dto.genre.GenreRequestDto;
import dev.lokeshbisht.SongService.entity.Genre;
import dev.lokeshbisht.SongService.mapper.GenreMapper;
import dev.lokeshbisht.SongService.repository.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GenreServiceImplTest {

    @Autowired
    private GenreService genreService;

    @Autowired
    private GenreMapper genreMapper;

    @Mock
    private GenreRepository genreRepository;

    @BeforeEach
    public void setup() {
        GenreRequestDto genreRequestDto = GenreRequestDto.builder().name("Alternate rock").createdBy("lokeshbisht@dev.com").build();
        Genre genre = genreMapper.toGenre(genreRequestDto);
        genre.setId(1L);
        Mockito.when(genreRepository.save(genre)).thenReturn(genre);
        genreService.addGenre(genreRequestDto);
    }

    @Test
    public void createGenreTest() {
        GenreRequestDto genreRequestDto = GenreRequestDto.builder().name("Pop").createdBy("lokeshbisht@dev.com").build();
        Genre genre = genreMapper.toGenre(genreRequestDto);
        Mockito.when(genreRepository.save(genre)).thenReturn(genre);
        assertEquals(genre.getName(), genreService.addGenre(genreRequestDto).getName());
    }

    @Test
    public void getGenreTest() {
        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("Alternate rock");
        Mockito.when(genreRepository.findById(1L)).thenReturn(Optional.of(genre));
        assertEquals("Alternate rock", genreService.findGenre(1L).getData().getName());
    }
}
