package dev.lokeshbisht.SongService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseDto<T> {

    private T data;

    private String message;

    private String[] errors;

    private MetaDataDto metaDataDto;
}
