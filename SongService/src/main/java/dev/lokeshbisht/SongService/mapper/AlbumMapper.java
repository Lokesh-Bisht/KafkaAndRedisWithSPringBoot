package dev.lokeshbisht.SongService.mapper;

import dev.lokeshbisht.SongService.dto.album.AlbumDto;
import dev.lokeshbisht.SongService.dto.album.AlbumRequestDto;
import dev.lokeshbisht.SongService.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AlbumMapper {

    Album toAlbum(AlbumRequestDto albumRequestDto);

    @Mapping(target = "albumId", source = "id")
    AlbumDto toAlbumDto(Album album);
}
