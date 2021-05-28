package com.tourism.tourism.userlogin;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class UserLoginBadRequestException extends RuntimeException {
    public UserLoginBadRequestException(String message) {
        super(message);
    }
}