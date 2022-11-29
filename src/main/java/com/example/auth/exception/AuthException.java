package com.example.auth.exception;

import lombok.Getter;

@Getter
public class AuthException extends RuntimeException {

    private final String code;
    private final int httpStatus;

    public AuthException(String message, String code, int httpStatus) {
        super(message);
        this.code = code;
        this.httpStatus = httpStatus;
    }
}
