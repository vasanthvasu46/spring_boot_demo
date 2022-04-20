package com.Employee.CustomException;

import org.springframework.http.HttpStatus;

public class NoElementWithGivenId extends RuntimeException{
    private HttpStatus httpStatus;
    private String errorMessage;

    public NoElementWithGivenId(){}

    public NoElementWithGivenId(HttpStatus httpStatus, String errorMessage) {
        super();
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
