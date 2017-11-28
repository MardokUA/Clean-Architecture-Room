package com.example.developer.roomexample.data.source;

import com.example.developer.roomexample.data.source.local.entity.UserContact;
import com.example.developer.roomexample.data.source.remote.model.Error;
import com.example.developer.roomexample.data.source.remote.model.User;

import java.util.List;

public interface UserDataSource {

    void getUserList(String resultCount, String params, BaseSourceCallback callback);

    void updateUserList(String resultCount, String params, BaseSourceCallback callback);

    void addUserContact(UserContact userContact, BaseSourceCallback callback);

    void addAllUsersContacts(BaseSourceCallback callback, UserContact... userContacts);

    interface BaseSourceCallback {
        void onSuccess(List<UserContact> userList);

        void onError(Error error);
    }
}
