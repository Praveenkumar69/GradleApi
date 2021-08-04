package com.RestApi.GradleApi.exception;


public class EmailAlreadyExists extends RuntimeException {
    private String message;

    public EmailAlreadyExists(String message) {
        super(message);
        this.message = message;
    }

    public EmailAlreadyExists() {
    }
}