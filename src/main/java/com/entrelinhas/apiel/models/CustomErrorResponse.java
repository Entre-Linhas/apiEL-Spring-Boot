package com.entrelinhas.apiel.models;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.micrometer.common.lang.NonNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomErrorResponse {

    public CustomErrorResponse(String message, HttpStatus status) {
        this.error = message;
        this.status = status.value();
        this.timestamp = LocalDateTime.now();
        this.statusText = status;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    @NonNull
    private Integer status;
    @NonNull
    private String error;
    @NonNull
    private HttpStatus statusText;
}
