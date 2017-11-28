package com.example.developer.roomexample.data.source;

import com.example.developer.roomexample.data.source.remote.model.Error;
import com.example.developer.roomexample.data.source.remote.model.User;

import java.util.List;

public interface UserDataSource {

    void getUserList(String resultCount, String params, SourceCallback callback);

    interface SourceCallback {

        void onSuccess(List<User> userList);

        void onError(Error error);
    }
}
