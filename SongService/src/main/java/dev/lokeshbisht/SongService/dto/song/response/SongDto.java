package dev.lokeshbisht.SongService.dto.song.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SongDto {

    @JsonProperty("id")
    private Long songId;

    @JsonProperty("artist_id")
    private Long artistId;

    @JsonProperty("album_id")
    private Long albumId;

    @JsonProperty("genre_id")
    private Long genreId;

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
