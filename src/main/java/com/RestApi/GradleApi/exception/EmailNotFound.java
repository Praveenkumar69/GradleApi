package com.RestApi.GradleApi.exception;

public class EmailNotFound extends RuntimeException {
    private String message;
    public EmailNotFound(String message) {
        super(message);
        this.message = message;
    }
    public EmailNotFound() {
    }
}