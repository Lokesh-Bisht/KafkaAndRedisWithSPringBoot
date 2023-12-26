package dev.lokeshbisht.PlaylistService.dto.playlist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowersDto {

    private String href;

    private Long total;
}
