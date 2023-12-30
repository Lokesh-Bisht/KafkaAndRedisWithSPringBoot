package dev.lokeshbisht.SongService.mapper;

import dev.lokeshbisht.SongService.dto.song.request.SongRequestDto;
import dev.lokeshbisht.SongService.entity.Song;
import dev.lokeshbisht.SongService.dto.song.response.SongDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SongMapper {

    Song toSong(SongRequestDto songRequestDto);

    @Mapping(target = "songId", source = "id")
    SongDto toSongDto(Song song);
}
