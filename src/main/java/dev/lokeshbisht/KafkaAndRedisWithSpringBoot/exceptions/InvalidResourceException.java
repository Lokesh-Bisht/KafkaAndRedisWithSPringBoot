package dev.lokeshbisht.KafkaAndRedisWithSpringBoot.exceptions;

import java.io.Serial;

public class InvalidResourceException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public InvalidResourceException(String message) {
        super(message);
    }
}
