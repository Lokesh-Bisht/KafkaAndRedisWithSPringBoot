package dev.lokeshbisht.SongService.service;

import dev.lokeshbisht.SongService.dto.ApiResponseDto;
import dev.lokeshbisht.SongService.dto.album.AlbumDto;
import dev.lokeshbisht.SongService.dto.album.AlbumRequestDto;

public interface AlbumService {

    AlbumDto addAlbum(AlbumRequestDto albumRequestDto);
    AlbumDto updateAlbum(AlbumRequestDto albumRequestDto, Long albumId);
    ApiResponseDto<AlbumDto> getAlbum(Long albumId);
}
