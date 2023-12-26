package dev.lokeshbisht.PlaylistService.dto.playlist.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.lokeshbisht.PlaylistService.dto.playlist.FollowersDto;
import dev.lokeshbisht.PlaylistService.dto.playlist.PlaylistImageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlaylistRequestDto {

    private String name;

    private boolean collaborative;

    private String description;

    @JsonProperty("followers")
    private FollowersDto followersDto;

    @JsonProperty("images")
    private List<PlaylistImageDto> playlistImageDto;

    private Boolean isPublic;

    @JsonProperty("tracks")
    private PlaylistTracksDto playlistTracksDto;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("created_by")
    private String createdBy;
}
