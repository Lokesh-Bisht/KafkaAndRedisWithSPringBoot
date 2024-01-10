package dev.lokeshbisht.SongService.exceptions;

import java.io.Serial;

public class AlbumNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public AlbumNotFoundException(String message) {
        super(message);
    }
}
