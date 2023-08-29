package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.spotify;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PlaylistDto {

    private String name;

    private boolean collaborative;

    private Long pid;

    @JsonProperty("modified_at")
    private Long modifiedAt;

    @JsonProperty("num_albums")
    private Integer albumsCount;

    @JsonProperty("num_tracks")
    private Integer tracksCount;

    @JsonProperty("num_followers")
    private Integer followers;

    @JsonProperty("num_edits")
    private Integer edits;

    @JsonProperty("tracks")
    private List<TracksDto> tracksDtoList;
}
