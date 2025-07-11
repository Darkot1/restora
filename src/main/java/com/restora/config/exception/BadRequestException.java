package com.restora.config.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BusinessException {
    private static final String CODE = "BAD_REQUEST";

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST, CODE);
    }
}
