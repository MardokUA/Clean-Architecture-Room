package com.example.developer.roomexample.data.source.model;

public class Error {

    public static final int SERVER_ERROR = 1001;
    public static final int CONNECTION_ERROR = 1002;

    private final int mError;

    public Error(int error) {
        mError = error;
    }

    public int getError() {
        return mError;
    }

    public String getErrorMessage() {
        String errorMessage;
        switch (mError) {
            case SERVER_ERROR:
                errorMessage = "Internal server error. Try again later";
                break;
            case CONNECTION_ERROR:
                errorMessage = "Connection error. Retry";
                break;
            default:
                errorMessage = "Something went wrong";
        }
        return errorMessage;
    }
}
