package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateSongRequestDto {

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

    private Long streams;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_by")
    private String updatedBy;
}
