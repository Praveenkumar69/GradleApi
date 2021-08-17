package com.RestApi.GradleApi.handler.ExceptionHandler;

import com.RestApi.GradleApi.exception.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class ValidationExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Object> handleExceptions(ValidationException exception, WebRequest webRequest) {
        String response = "Validation Error with code " + exception.getErrorCode();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    //DatabaseException


}
