package com.bt.networkservice.exception;

public class InvalidFieldException extends RuntimeException{
    private String message;
    public InvalidFieldException(String message){
        this.message = message;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
