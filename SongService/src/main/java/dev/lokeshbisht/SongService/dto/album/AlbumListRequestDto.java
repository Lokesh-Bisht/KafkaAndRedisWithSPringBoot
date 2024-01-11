package dev.lokeshbisht.SongService.dto.album;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AlbumListRequestDto {

    @JsonProperty("album_id_list")
    private List<Long> albumIdList;
}
