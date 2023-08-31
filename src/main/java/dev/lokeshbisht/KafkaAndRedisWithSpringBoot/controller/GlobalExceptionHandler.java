package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.controller;

import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.dto.ErrorResponseDto;
import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.enums.ErrorCode;
import dev.lokeshbisht.KafkaAndRedisWithSpringBoot.exceptions.InvalidResourceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidResourceException.class)
    public ResponseEntity<ErrorResponseDto> handleInvalidResourceException(InvalidResourceException ex) {
        log.error("InvalidResourceException: {}", ex.getMessage());
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.INVALID_RESOURCE, ex.getMessage());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleAllException(Exception ex) {
        UUID uuid = UUID.randomUUID();
        String message = String.format("Unhandled exception, logged against error id: %s", uuid);
        log.error("Exception: {} {}", message, ex.getClass().getName(), ex);
        log.error(ex.getMessage(), ex);
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(ErrorCode.INTERNAL_SERVER_ERROR, message);
        return new ResponseEntity<>(errorResponseDto, HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
