package com.RestApi.GradleApi.exception.constants;

public enum ExceptionConstants {
    EMAIL_NOT_FOUND("001"),
    USER_NOT_FOUND("002");

    private String errorCode;

    ExceptionConstants(String errorCode){
        this.errorCode=errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}
