package com.tourism.tourism.evaluation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EvaluationBadRequestException extends RuntimeException {
    public EvaluationBadRequestException(String message) {
        super(message);
    }
}