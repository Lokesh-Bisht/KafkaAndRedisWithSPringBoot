package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TracksDto {

    private Integer pos;

    @JsonProperty("artist_name")
    private String artistName;

    @JsonProperty("track_uri")
    private String trackUri;

    @JsonProperty("artist_uri")
    private String artistUri;

    @JsonProperty("track_name")
    private String trackName;

    @JsonProperty("album_uri")
    private String albumUri;

    @JsonProperty("duration_ms")
    private Long duration;

    @JsonProperty("album_name")
    private String albumName;
}
