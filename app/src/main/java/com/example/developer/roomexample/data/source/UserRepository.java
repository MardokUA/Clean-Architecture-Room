package com.example.developer.roomexample.data.source;

import com.example.developer.roomexample.data.source.local.LocalDataSource;
import com.example.developer.roomexample.data.source.remote.RemoteDataSource;
import com.example.developer.roomexample.data.source.remote.model.Error;
import com.example.developer.roomexample.data.source.remote.model.RequestResponse;
import com.example.developer.roomexample.data.source.remote.model.User;
import com.example.developer.roomexample.data.source.remote.ApiFactory;
import com.example.developer.roomexample.data.source.remote.UserApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository implements UserDataSource {

    private static UserRepository instance;
    private LocalDataSource mLocalDataSource;
    private RemoteDataSource mRemoteDataSource;
    private UserApi mUserApi;

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private UserRepository() {
        mUserApi = ApiFactory.getInstance().getRetrofit().create(UserApi.class);
        mLocalDataSource = LocalDataSource.getInstance();
        mRemoteDataSource = RemoteDataSource.getInstance();
    }

    @Override
    public void getUserList(String resultCount, String params, final SourceCallback callback) {
        mUserApi.getUserList(resultCount, params).enqueue(new Callback<RequestResponse>() {
            @Override
            public void onResponse(Call<RequestResponse> call, Response<RequestResponse> response) {
                if (response.body() == null) {
                    callback.onError(new Error(Error.SERVER_ERROR));
                    return;
                }
                List<User> responseList = response.body().getUserList();
                callback.onSuccess(responseList);
            }

            @Override
            public void onFailure(Call<RequestResponse> call, Throwable t) {
                callback.onError(new Error(Error.CONNECTION_ERROR));
            }
        });
    }
}
