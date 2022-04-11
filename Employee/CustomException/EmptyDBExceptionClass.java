package com.Employee.CustomException;

public class EmptyDBExceptionClass extends RuntimeException {
    private String errorCode;
    private String errorMessage;

    EmptyDBExceptionClass(){}

    public EmptyDBExceptionClass(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
