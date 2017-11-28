package com.example.developer.roomexample.data.source.remote;

import android.support.annotation.NonNull;

import com.example.developer.roomexample.data.source.UserDataSource;
import com.example.developer.roomexample.data.source.local.entity.UserContact;
import com.example.developer.roomexample.data.source.mapper.UserContactMapper;
import com.example.developer.roomexample.data.source.remote.model.Error;
import com.example.developer.roomexample.data.source.remote.model.RequestResponse;
import com.example.developer.roomexample.data.source.remote.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource implements UserDataSource {

    private static RemoteDataSource sInstance;

    private UserApi mUserApi;

    public static RemoteDataSource getInstance() {
        if (sInstance == null) {
            sInstance = new RemoteDataSource();
        }
        return sInstance;
    }

    private RemoteDataSource() {
        mUserApi = ApiFactory.getInstance().getRetrofit().create(UserApi.class);
    }

    @Override
    public void getUserList(String resultCount, String params, final BaseSourceCallback callback) {
        mUserApi.getUserList(resultCount, params).enqueue(new Callback<RequestResponse>() {
            @Override
            public void onResponse(@NonNull Call<RequestResponse> call, @NonNull Response<RequestResponse> response) {
                if (response.body() == null) {
                    callback.onError(new Error(Error.SERVER_ERROR));
                    return;
                }
                List<User> responseList = response.body().getUserList();
                UserContactMapper mapper = new UserContactMapper(responseList);
                List<UserContact> userContactList = mapper.transmorph();
                callback.onSuccess(userContactList);
            }

            @Override
            public void onFailure(@NonNull Call<RequestResponse> call, @NonNull Throwable t) {
                callback.onError(new Error(Error.CONNECTION_ERROR));
            }
        });
    }

    @Override
    public void updateUserList(String resultCount, String params, BaseSourceCallback callback) {
        getUserList(resultCount, params, callback);
    }

    @Override
    public void addUserContact(UserContact userContact, BaseSourceCallback callback) {

    }

    @Override
    public void addAllUsersContacts(BaseSourceCallback callback, UserContact... userContacts) {

    }
}
