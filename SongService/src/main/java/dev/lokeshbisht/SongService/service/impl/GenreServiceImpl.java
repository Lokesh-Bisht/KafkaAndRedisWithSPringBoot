package dev.lokeshbisht.SongService.service.impl;

import dev.lokeshbisht.SongService.dto.genre.GenreDto;
import dev.lokeshbisht.SongService.dto.genre.GenreRequestDto;
import dev.lokeshbisht.SongService.entity.Genre;
import dev.lokeshbisht.SongService.mapper.GenreMapper;
import dev.lokeshbisht.SongService.repository.GenreRepository;
import dev.lokeshbisht.SongService.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    @Autowired
    private GenreMapper genreMapper;

    private static final Logger logger = LoggerFactory.getLogger(GenreServiceImpl.class);

    @Override
    public GenreDto addGenre(GenreRequestDto genreRequestDto) {
        logger.info("Create new genre: {}", genreRequestDto);
        Genre genre = genreMapper.toGenre(genreRequestDto);
        genre.setCreatedAt(new Date());
        return genreMapper.toGenreDto(genreRepository.save(genre));
    }
}
