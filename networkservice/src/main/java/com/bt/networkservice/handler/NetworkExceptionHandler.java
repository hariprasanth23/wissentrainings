package com.bt.networkservice.handler;

import com.bt.networkservice.exception.InvalidFieldException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NetworkExceptionHandler {

    @ExceptionHandler
    public String handleInvalidFieldException(InvalidFieldException exception){
        return exception.getMessage();
    }
}
