package com.tourism.tourism.photo;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PhotoBadRequestException extends RuntimeException {
    public PhotoBadRequestException(String message) {
        super(message);
    }
}//teste