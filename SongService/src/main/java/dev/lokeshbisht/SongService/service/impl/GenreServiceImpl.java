package dev.lokeshbisht.SongService.service.impl;

import dev.lokeshbisht.SongService.dto.ApiResponseDto;
import dev.lokeshbisht.SongService.dto.MetaDataDto;
import dev.lokeshbisht.SongService.dto.genre.GenreDto;
import dev.lokeshbisht.SongService.dto.genre.GenreRequestDto;
import dev.lokeshbisht.SongService.entity.Genre;
import dev.lokeshbisht.SongService.exceptions.GenreNotFoundException;
import dev.lokeshbisht.SongService.mapper.GenreMapper;
import dev.lokeshbisht.SongService.repository.GenreRepository;
import dev.lokeshbisht.SongService.service.GenreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public GenreDto updateGenre(GenreRequestDto genreRequestDto, Long genreId) {
        logger.info("Update genre: {} with new info: {}", genreRequestDto, genreRequestDto);
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isEmpty()) {
            throw new GenreNotFoundException("Genre doesn't exist");
        }
        Genre updatedGenre = genreMapper.toGenre(genreRequestDto);
        updatedGenre.setId(genre.get().getId());
        updatedGenre.setCreatedAt(genre.get().getCreatedAt());
        updatedGenre.setCreatedBy(genre.get().getCreatedBy());
        updatedGenre.setUpdatedAt(new Date());
        return genreMapper.toGenreDto(genreRepository.save(updatedGenre));
    }

    private MetaDataDto generateApiResponseMetadata(int page, int size, int total, double startTime) {
        return MetaDataDto.builder()
            .page(page)
            .size(size)
            .total(total)
            .took(System.currentTimeMillis() - startTime)
            .build();
    }

    @Override
    public ApiResponseDto<GenreDto> findGenre(Long genreId) {
        double startTime = System.currentTimeMillis();
        logger.info("Fetch genre: {}", genreId);
        Optional<Genre> genre = genreRepository.findById(genreId);
        if (genre.isEmpty()) {
            throw new GenreNotFoundException("Genre doesn't exist");
        }
        GenreDto genreDto = genreMapper.toGenreDto(genre.get());
        return new ApiResponseDto<>(genreDto, "OK", null, generateApiResponseMetadata(1, 1, 1, startTime));
    }

    @Override
    public ApiResponseDto<List<GenreDto>> findAllGenres() {
        double startTime = System.currentTimeMillis();
        logger.info("Fetch all genres.");
        List<Genre> genres = genreRepository.findAll();
        List<GenreDto> genreDtoList = new ArrayList<>();
        for (Genre genre : genres) {
            genreDtoList.add(genreMapper.toGenreDto(genre));
        }
        return new ApiResponseDto<>(genreDtoList, "OK", null, generateApiResponseMetadata(1, 1, genreDtoList.size(), startTime));
    }
}
