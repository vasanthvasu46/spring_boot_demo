package com.employee.customexception;

public class EmptyFieldException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public EmptyFieldException() {
    }

    public EmptyFieldException(String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public EmptyFieldException(String errorMessage) {
        super();
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