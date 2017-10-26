package com.example.developer.roomexample.data.source.remote;

import com.example.developer.roomexample.userlist.domain.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApi {

    @GET("?results=100")
    Call<List<User>> getUserList();

}
