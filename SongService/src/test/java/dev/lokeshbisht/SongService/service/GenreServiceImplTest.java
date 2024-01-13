package dev.lokeshbisht.SongService.service;

import dev.lokeshbisht.SongService.dto.genre.GenreRequestDto;
import dev.lokeshbisht.SongService.entity.Genre;
import dev.lokeshbisht.SongService.mapper.GenreMapper;
import dev.lokeshbisht.SongService.repository.GenreRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class GenreServiceImplTest {

    @Autowired
    private GenreService genreService;

    @Autowired
    private GenreMapper genreMapper;

    @MockBean
    private GenreRepository genreRepository;

    @BeforeEach
    public void setup() {
        GenreRequestDto genreRequestDto = GenreRequestDto.builder().name("Alternate rock").createdBy("lokeshbisht@dev.com").build();
        Genre genre = genreMapper.toGenre(genreRequestDto);
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
}
