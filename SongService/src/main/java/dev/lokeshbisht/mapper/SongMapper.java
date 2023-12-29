package dev.lokeshbisht.mapper;

import dev.lokeshbisht.dto.song.SongDto;
import dev.lokeshbisht.dto.song.request.SongRequestDto;
import dev.lokeshbisht.entity.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {

    Song toSong(SongRequestDto songRequestDto);
    SongDto toSongDto(Song song);
}
