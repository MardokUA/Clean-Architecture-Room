package com.example.developer.roomexample.data.source;

import com.example.developer.roomexample.data.source.local.LocalDataSource;
import com.example.developer.roomexample.data.source.local.entity.UserContact;
import com.example.developer.roomexample.data.source.remote.RemoteDataSource;
import com.example.developer.roomexample.data.source.remote.model.Error;

import java.util.List;

public class UserRepository implements UserDataSource {

    private static UserRepository instance;

    private LocalDataSource mLocalDataSource;
    private RemoteDataSource mRemoteDataSource;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        mLocalDataSource = LocalDataSource.getInstance();
        mRemoteDataSource = RemoteDataSource.getInstance();
    }

    @Override
    public void getUserList(final String resultCount, final String params, final BaseSourceCallback callback) {
        mLocalDataSource.getUserList(resultCount, params, new BaseSourceCallback() {
            @Override
            public void onSuccess(List<UserContact> userList) {
                callback.onSuccess(userList);
            }

            @Override
            public void onError(Error error) {
                mRemoteDataSource.getUserList(resultCount, params, new BaseSourceCallback() {
                    @Override
                    public void onSuccess(List<UserContact> userList) {
                        mLocalDataSource.addAllUsersContacts(callback, userList.toArray(new UserContact[userList.size()]));
                        callback.onSuccess(userList);
                    }

                    @Override
                    public void onError(Error error) {
                        callback.onError(error);
                    }
                });
            }
        });
    }

    @Override
    public void updateUserList(final String resultCount, final String params, final BaseSourceCallback callback) {
        mLocalDataSource.updateUserList(resultCount, params, new BaseSourceCallback() {
            @Override
            public void onSuccess(List<UserContact> userList) {
                mRemoteDataSource.getUserList(resultCount, params, new BaseSourceCallback() {
                    @Override
                    public void onSuccess(List<UserContact> userList) {
                        mLocalDataSource.addAllUsersContacts(callback, userList.toArray(new UserContact[userList.size()]));
                        callback.onSuccess(userList);
                    }

                    @Override
                    public void onError(Error error) {
                        callback.onError(error);
                    }
                });
            }

            @Override
            public void onError(Error error) {

            }
        });
    }

    @Override
    public void addUserContact(UserContact userContact, BaseSourceCallback callback) {
        mLocalDataSource.addUserContact(userContact, callback);
    }

    @Override
    public void addAllUsersContacts(BaseSourceCallback callback, UserContact... userContacts) {

    }
}
