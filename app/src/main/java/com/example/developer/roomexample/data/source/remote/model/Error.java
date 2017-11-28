package com.example.developer.roomexample.data.source.remote.model;

public class Error {

    public static final int SERVER_ERROR = 1001;
    public static final int CONNECTION_ERROR = 1002;
    public static final int LOCAL_STORAGE_EMPTY_ERROR = 1003;

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
            case LOCAL_STORAGE_EMPTY_ERROR:
                errorMessage = "Local storage is empty";
                break;
            default:
                errorMessage = "Something went wrong";
        }
        return errorMessage;
    }
}
