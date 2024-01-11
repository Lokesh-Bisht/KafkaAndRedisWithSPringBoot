package dev.lokeshbisht.SongService.service.impl;

import dev.lokeshbisht.SongService.dto.ApiResponseDto;
import dev.lokeshbisht.SongService.dto.MetaDataDto;
import dev.lokeshbisht.SongService.dto.album.AlbumDto;
import dev.lokeshbisht.SongService.dto.album.AlbumRequestDto;
import dev.lokeshbisht.SongService.entity.Album;
import dev.lokeshbisht.SongService.exceptions.AlbumNotFoundException;
import dev.lokeshbisht.SongService.mapper.AlbumMapper;
import dev.lokeshbisht.SongService.repository.AlbumRepository;
import dev.lokeshbisht.SongService.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumMapper albumMapper;

    private static final Logger logger = LoggerFactory.getLogger(AlbumServiceImpl.class);

    @Override
    public AlbumDto addAlbum(AlbumRequestDto albumRequestDto) {
        logger.info("Create a new album: {}", albumRequestDto);
        Album album = albumMapper.toAlbum(albumRequestDto);
        album.setCreatedAt(new Date());
        return albumMapper.toAlbumDto(albumRepository.save(album));
    }

    @Override
    public AlbumDto updateAlbum(AlbumRequestDto albumRequestDto, Long albumId) {
        logger.info("Update album: {} with new info: {}", albumId, albumRequestDto);
        Optional<Album> album = albumRepository.findById(albumId);
        if (album.isEmpty()) {
            throw new AlbumNotFoundException("Album "+ albumId + " doesn't exist.");
        }
        Album updatedAlbum = albumMapper.toAlbum(albumRequestDto);
        updatedAlbum.setId(albumId);
        updatedAlbum.setCreatedAt(album.get().getCreatedAt());
        updatedAlbum.setCreatedBy(album.get().getCreatedBy());
        updatedAlbum.setUpdatedAt(new Date());
        return albumMapper.toAlbumDto(albumRepository.save(updatedAlbum));
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
    public ApiResponseDto<AlbumDto> getAlbum(Long albumId) {
        logger.info("Fetch album {}", albumId);
        double startTime = System.currentTimeMillis();
        Optional<Album> album = albumRepository.findById(albumId);
        if (album.isEmpty()) {
            throw new AlbumNotFoundException("Album "+ albumId + " doesn't exist.");
        }
        AlbumDto albumDto = albumMapper.toAlbumDto(album.get());
        return new ApiResponseDto<>(albumDto, "OK", null, generateApiResponseMetadata(1, 1, 1, startTime));
    }
}
