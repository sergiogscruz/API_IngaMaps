package com.tourism.tourism.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PersonBadRequestException extends RuntimeException {
    public PersonBadRequestException(String message) {
        super(message);
    }
}