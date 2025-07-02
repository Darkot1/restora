package com.restora.config.exception;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BusinessException {
    private static final String CODE = "RESOURCE_NOT_FOUND";

    public ResourceNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND, CODE);
    }

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s no encontrado con %s: '%s'", resourceName, fieldName, fieldValue),
              HttpStatus.NOT_FOUND, CODE);
    }
}
