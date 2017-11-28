package com.example.developer.roomexample.data.source.remote;

import com.example.developer.roomexample.data.source.UserDataSource;

public class RemoteDataSource implements UserDataSource {

    private static RemoteDataSource sInstance;

    public static RemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new RemoteDataSource();
        }
        return sInstance;
    }

    @Override
    public void getUserList(String resultCount, String params, SourceCallback callback) {

    }
}
