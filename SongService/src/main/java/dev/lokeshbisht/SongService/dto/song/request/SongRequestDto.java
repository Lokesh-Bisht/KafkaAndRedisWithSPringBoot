package dev.lokeshbisht.SongService.dto.song.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

import static dev.lokeshbisht.SongService.constants.JsonConstants.ISO8601;

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

    private Long streams;

    @JsonProperty("created_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO8601)
    private Date createdAt;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = ISO8601)
    private Date updatedAt;

    @JsonProperty("updated_by")
    private String updatedBy;
}
