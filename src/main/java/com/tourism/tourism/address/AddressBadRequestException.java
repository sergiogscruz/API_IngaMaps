package com.tourism.tourism.address;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class AddressBadRequestException extends RuntimeException {
    public AddressBadRequestException(String message) {
        super(message);
    }
}
