package dev.lokeshbisht.SongService.controller;

import dev.lokeshbisht.SongService.dto.ErrorResponseDto;
import dev.lokeshbisht.SongService.enums.ErrorCode;
import dev.lokeshbisht.SongService.exceptions.AlbumNotFoundException;
import dev.lokeshbisht.SongService.exceptions.GenreNotFoundException;
import dev.lokeshbisht.SongService.exceptions.InvalidResourceException;
import dev.lokeshbisht.SongService.exceptions.SongNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(SongNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleSongNotFoundException(SongNotFoundException ex) {
        log.error("Encountered SongNotFoundException: {}", ex.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.SONG_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GenreNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleGenreNotFoundException(GenreNotFoundException ex) {
        log.error("Encountered GenreNotFoundException: {}", ex.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.GENRE_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlbumNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleAlbumNotFoundException(AlbumNotFoundException ex) {
        log.error("Encountered AlbumNotFoundException: {}", ex.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.ALBUM_NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidResourceException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidResourceException(InvalidResourceException ex) {
        log.error("InvalidResourceException: {}", ex.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.INVALID_RESOURCE, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleAllExceptions(Exception ex) {
        UUID uuid = UUID.randomUUID();
        String message = String.format("Unhandled exception, logged against error id: %s", uuid);
        log.error("Exception: {} {}", message, ex.getClass().getName(), ex);
        log.error(ex.getMessage(), ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.INTERNAL_SERVER_ERROR, message);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
