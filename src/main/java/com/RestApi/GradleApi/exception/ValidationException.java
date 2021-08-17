package com.RestApi.GradleApi.exception;

import com.RestApi.GradleApi.exception.constants.ExceptionConstants;

public class ValidationException extends RuntimeException {
    private String name;
    private String errorCode;
    public ValidationException(ExceptionConstants errorCode) {
        super(errorCode.name());
        this.name = errorCode.name();
        this.errorCode=errorCode.getErrorCode();
    }

    @Override
    public String getMessage() {
        return name;
    }

    public String getErrorCode() {
        return errorCode;
    }
}