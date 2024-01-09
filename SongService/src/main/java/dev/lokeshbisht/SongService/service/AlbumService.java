package dev.lokeshbisht.SongService.service;

import dev.lokeshbisht.SongService.dto.album.AlbumDto;
import dev.lokeshbisht.SongService.dto.album.AlbumRequestDto;

public interface AlbumService {

    AlbumDto addAlbum(AlbumRequestDto albumRequestDto);
}
