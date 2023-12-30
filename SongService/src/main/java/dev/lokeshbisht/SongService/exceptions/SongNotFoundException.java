package dev.lokeshbisht.SongService.exceptions;

import java.io.Serial;

public class SongNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public SongNotFoundException(String message) {
        super(message);
    }
}
