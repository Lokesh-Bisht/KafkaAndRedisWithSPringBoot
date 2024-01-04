package dev.lokeshbisht.SongService.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MetaDataDto {

    private int page;

    private int size;

    private int total;

    private double took;
}
