package dev.lokeshbisht.SongService.dto.song.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SongPlayCountRequestDto {

    @JsonProperty("play_count")
    private Long playCount;
}
