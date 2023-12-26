package dev.lokeshbisht.PlaylistService.dto.playlist.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistTracksDto {

    private String href;

    private Integer limit;

    private String next;

    private Integer offset;

    private String previous;

    private Integer total;

    private String type;

    private String uri;

    private List<PlaylistTracksDto> playlistTracksDtoList;
}
