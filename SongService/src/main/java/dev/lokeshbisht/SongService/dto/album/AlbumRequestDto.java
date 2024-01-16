package dev.lokeshbisht.SongService.dto.album;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AlbumRequestDto {

    @NotBlank(message = "Album name is a required field. It can't be blank.")
    @JsonProperty("album_type")
    private String albumType;

    @NotNull(message = "Total tracks is a required field.")
    @PositiveOrZero(message = "Total tracks should be zero or more.")
    @JsonProperty("total_tracks")
    private Integer totalTracks;

    @JsonProperty("available_markets")
    private List<String> availableMarkets;

    @NotNull(message = "A url to the album is required.")
    private String href;

    @JsonProperty("created_by")
    private String createdBy;

    @JsonProperty("updated_by")
    private String updatedBy;
}
