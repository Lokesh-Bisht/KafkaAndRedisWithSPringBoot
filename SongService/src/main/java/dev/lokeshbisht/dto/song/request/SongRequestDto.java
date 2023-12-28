package dev.lokeshbisht.dto.song.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongRequestDto {

    @JsonProperty("artist_id")
    private Long artistId;

    @JsonProperty("album_id")
    private Long albumId;

    @JsonProperty("href")
    private String href;

    private String type;

    private String format;

    private Integer duration;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_at")
    private Date updatedAt;

    @JsonProperty("updated_by")
    private String updatedBy;
}
