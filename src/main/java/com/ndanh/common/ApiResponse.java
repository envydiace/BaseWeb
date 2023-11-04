package com.ndanh.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ApiResponse extends ResponseEntity<ObjectResponse> {

    public ApiResponse(HttpStatusCode status) {
        super(status);
    }

    public ApiResponse(Object data) {
        super(new ObjectResponse(HttpStatus.OK.value(), data, "Success"), HttpStatus.OK);
    }

    public ApiResponse(String errorMessage, HttpStatus status) {
        super(new ObjectResponse(status.value(), null, errorMessage), status);
    }

    public ApiResponse(Object data, String message) {
        super(new ObjectResponse(HttpStatus.OK.value(), data, message), HttpStatus.OK);
    }
}
