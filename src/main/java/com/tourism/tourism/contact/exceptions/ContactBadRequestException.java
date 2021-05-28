package com.tourism.tourism.contact.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class ContactBadRequestException extends RuntimeException {
    public ContactBadRequestException(String message) {
        super(message);
    }
}
