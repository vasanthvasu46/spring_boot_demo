package com.swagger.customexception;

public class EmptyDbException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public EmptyDbException() {
    }

    public EmptyDbException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public EmptyDbException(String errorCode, String errorMessage) {
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
