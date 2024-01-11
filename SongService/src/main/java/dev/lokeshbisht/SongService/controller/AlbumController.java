package dev.lokeshbisht.SongService.controller;

import dev.lokeshbisht.SongService.dto.ApiResponseDto;
import dev.lokeshbisht.SongService.dto.album.AlbumDto;
import dev.lokeshbisht.SongService.dto.album.AlbumRequestDto;
import dev.lokeshbisht.SongService.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/album")
    public AlbumDto createAlbum(@RequestBody AlbumRequestDto albumRequestDto) {
        return albumService.addAlbum(albumRequestDto);
    }

    @PostMapping("/album/{albumId}")
    public AlbumDto updateAlbum(@RequestBody AlbumRequestDto albumRequestDto, @PathVariable Long albumId) {
        return albumService.updateAlbum(albumRequestDto, albumId);
    }

    @GetMapping("/album/{albumId}")
    public ApiResponseDto<AlbumDto> getAlbum(@PathVariable Long albumId) {
        return albumService.getAlbum(albumId);
    }
}
