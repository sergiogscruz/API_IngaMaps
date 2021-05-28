package com.tourism.tourism.personaddress.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class PersonAddressBadRequestException extends RuntimeException {
    public PersonAddressBadRequestException(String message) {
        super(message);
    }
}
