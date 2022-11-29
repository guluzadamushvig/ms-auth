package com.example.auth.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static com.example.auth.model.constant.ExceptionConstants.UNEXPECTED_EXCEPTION_CODE;
import static com.example.auth.model.constant.ExceptionConstants.UNEXPECTED_EXCEPTION_MESSAGE;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(INTERNAL_SERVER_ERROR)
    public ExceptionResponse handle(Exception ex) {
        log.error("Exception: ", ex);
        return new ExceptionResponse(UNEXPECTED_EXCEPTION_CODE, UNEXPECTED_EXCEPTION_MESSAGE);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ExceptionResponse> handle(AuthException ex) {

        log.error("AuthException: ", ex);
        return ResponseEntity
                .status(ex.getHttpStatus())
                .body(new ExceptionResponse(ex.getCode(), ex.getMessage()));
    }
}