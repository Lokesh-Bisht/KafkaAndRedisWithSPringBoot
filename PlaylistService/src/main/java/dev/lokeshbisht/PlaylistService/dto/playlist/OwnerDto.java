package dev.lokeshbisht.PlaylistService.dto.playlist;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {

    private Long id;

    private String type;

    @JsonProperty("followers")
    private FollowersDto followersDto;

    private String href;

    private String uri;

    @JsonProperty("display_name")
    private String displayName;
}
