package com.tourism.tourism.local.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class LocalBadRequestException extends RuntimeException {
    public LocalBadRequestException(String message) {
        super(message);
    }
}