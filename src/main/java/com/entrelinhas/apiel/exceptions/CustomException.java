package com.entrelinhas.apiel.exceptions;

import org.springframework.http.HttpStatus;

import com.entrelinhas.apiel.models.CustomErrorResponse;

public class CustomException extends RuntimeException {
    private final CustomErrorResponse errorResponse;

    public CustomException(String message, HttpStatus status) {
        this.errorResponse = new CustomErrorResponse(message, status);
    }

    public CustomErrorResponse getErrorResponse() {
        return errorResponse;
    }

    @Override
    public StackTraceElement[] getStackTrace() {
        // TODO Auto-generated method stub
        return null;
    }
}