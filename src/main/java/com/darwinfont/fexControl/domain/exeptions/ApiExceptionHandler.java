package com.darwinfont.fexControl.domain.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(NotFoundError.class)
    public ResponseEntity<BodyException> notFoundException(NotFoundError err) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(err.getBody());
    }
}
