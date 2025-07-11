package com.restora.config.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends BusinessException {
    private static final String CODE = "AUTHENTICATION_ERROR";

    public AuthenticationException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, CODE);
    }
}
