package com.example.developer.roomexample.data.source.remote;

import com.example.developer.roomexample.data.source.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserApi {

    @GET
    Call<List<User>> getUserList(@Query("results") String results,
                                 @Query("inc") String includes);

}
