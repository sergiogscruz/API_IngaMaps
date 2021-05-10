package com.tourism.tourism.event;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EventBadRequestException extends RuntimeException {
    public EventBadRequestException(String message) {
        super(message);
    }
}