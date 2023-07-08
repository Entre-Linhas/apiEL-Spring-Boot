package com.entrelinhas.apiel.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.entrelinhas.apiel.models.CustomErrorResponse;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomException(CustomException ex) {
        CustomErrorResponse errorResponse = ex.getErrorResponse();
        return ResponseEntity.status(ex.getErrorResponse().getStatus()).body(errorResponse);
    }

    // Outros métodos para manipular outras exceções personalizadas, se necessário

}
