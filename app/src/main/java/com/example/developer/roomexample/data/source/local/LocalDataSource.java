package com.example.developer.roomexample.data.source.local;

import android.arch.persistence.room.Room;

import com.example.developer.roomexample.application.RoomExample;
import com.example.developer.roomexample.data.source.UserDataSource;
import com.example.developer.roomexample.data.source.local.entity.UserContact;
import com.example.developer.roomexample.data.source.remote.model.Error;

import java.util.ArrayList;
import java.util.List;

public class LocalDataSource implements UserDataSource {

    private static final String DB_NAME = "users_db";

    private static LocalDataSource sInstance;
    private UserLocalDataBase mDataBase;

    private List<UserContact> mCachedUserContacts;

    public static LocalDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new LocalDataSource();
        }
        return sInstance;
    }

    private LocalDataSource() {
        mDataBase = Room.databaseBuilder(RoomExample.getContext(), UserLocalDataBase.class, DB_NAME).build();
        mCachedUserContacts = new ArrayList<>(25);
    }

    @Override
    public void getUserList(String resultCount, String params, final BaseSourceCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mCachedUserContacts.clear();
                mCachedUserContacts = mDataBase.getUserDao().getAllUsers();
                if (mCachedUserContacts == null || mCachedUserContacts.isEmpty()) {
                    callback.onError(new Error(Error.LOCAL_STORAGE_EMPTY_ERROR));
                } else {
                    callback.onSuccess(mCachedUserContacts);
                }
            }
        }).start();
    }

    @Override
    public void updateUserList(String resultCount, String params, final BaseSourceCallback callback) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mDataBase.getUserDao().deleteAllContacts(mCachedUserContacts.toArray(new UserContact[mCachedUserContacts.size()]));
                callback.onSuccess(null);
            }
        }).start();
    }

    @Override
    public void addUserContact(UserContact userContact, BaseSourceCallback callback) {

    }

    @Override
    public void addAllUsersContacts(BaseSourceCallback callback, final UserContact... userContacts) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mDataBase.getUserDao().insertAll(userContacts);
            }
        }).start();
    }
}
