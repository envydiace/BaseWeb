package com.ndanh.exception;

import com.ndanh.common.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ApiResponse handlerNotFoundException(NotFoundException ex, WebRequest req) {
        log.error(ex.getMessage(), ex);
        return new ApiResponse(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DuplicateIdException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlerDuplicateException(DuplicateIdException ex, WebRequest req) {
        return new ErrorResponse(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler(ValidateException.class)
    public ApiResponse handleValidateException(ValidateException ex, WebRequest request) {
        log.error(ex.getMessage(), ex);
        return new ApiResponse(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
