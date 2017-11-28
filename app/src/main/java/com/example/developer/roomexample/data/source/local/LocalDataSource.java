package com.example.developer.roomexample.data.source.local;

import android.arch.persistence.room.Room;

import com.example.developer.roomexample.application.RoomExample;
import com.example.developer.roomexample.data.source.UserDataSource;
import com.example.developer.roomexample.data.source.local.entity.UserContact;

import java.util.List;

public class LocalDataSource implements UserDataSource {

    private static final String DB_NAME = "users_db";

    private static LocalDataSource sInstance;
    private UserLocalDataBase mDataBase;

    public static LocalDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new LocalDataSource();
        }
        return sInstance;
    }

    private LocalDataSource() {
        mDataBase = Room.databaseBuilder(RoomExample.getContext(), UserLocalDataBase.class, DB_NAME).build();
    }

    @Override
    public void getUserList(String resultCount, String params, SourceCallback callback) {
        List<UserContact> allUsers = mDataBase.getUserDao().getAllUsers();
    }
}
