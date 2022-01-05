package com.ndanh.controller.exception;

public class DuplicateIdException extends RuntimeException{
    public DuplicateIdException(String message){
        super(message);
    }
}
