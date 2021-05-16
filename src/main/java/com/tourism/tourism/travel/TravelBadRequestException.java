package com.tourism.tourism.travel;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class TravelBadRequestException extends RuntimeException {
    public TravelBadRequestException(String message) {
        super(message);
    }
}