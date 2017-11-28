package com.example.developer.roomexample.data.source.local;

import com.example.developer.roomexample.data.source.UserDataSource;

public class LocalDataSource implements UserDataSource {

    private static LocalDataSource sInstance;

    public static LocalDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new LocalDataSource();
        }
        return sInstance;
    }

    @Override
    public void getUserList(String resultCount, String params, SourceCallback callback) {

    }
}
