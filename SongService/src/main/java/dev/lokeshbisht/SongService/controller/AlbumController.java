package dev.lokeshbisht.SongService.controller;

import dev.lokeshbisht.SongService.dto.ApiResponseDto;
import dev.lokeshbisht.SongService.dto.album.AlbumDto;
import dev.lokeshbisht.SongService.dto.album.AlbumListRequestDto;
import dev.lokeshbisht.SongService.dto.album.AlbumRequestDto;
import dev.lokeshbisht.SongService.service.AlbumService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/v1")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @PostMapping("/album")
    public AlbumDto createAlbum(@Valid @RequestBody AlbumRequestDto albumRequestDto) {
        return albumService.addAlbum(albumRequestDto);
    }

    @PutMapping("/album/{albumId}")
    public AlbumDto updateAlbum(@Valid @RequestBody AlbumRequestDto albumRequestDto, @PathVariable Long albumId) {
        return albumService.updateAlbum(albumRequestDto, albumId);
    }

    @GetMapping("/album/{albumId}")
    public ApiResponseDto<AlbumDto> getAlbum(@PathVariable Long albumId) {
        return albumService.getAlbum(albumId);
    }

    @PostMapping("/album/list")
    public ApiResponseDto<List<AlbumDto>> getAllAlbumsInList(@RequestBody AlbumListRequestDto albumListRequestDto) {
        return albumService.getAllAlbumsInList(albumListRequestDto);
    }
}
