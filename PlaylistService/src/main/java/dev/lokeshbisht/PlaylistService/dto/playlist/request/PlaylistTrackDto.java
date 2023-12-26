package dev.lokeshbisht.PlaylistService.dto.playlist.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistTrackDto {

    @JsonProperty("track_id")
    private Long trackId;

    @JsonProperty("album_id")
    private Long albumId;

    @JsonProperty("added_at")
    private Date addedAt;

    @JsonProperty("added_by")
    private String addedBy;

}
