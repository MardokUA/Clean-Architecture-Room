package com.example.developer.roomexample.data.source.remote;

import com.example.developer.roomexample.data.source.model.RequestResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserApi {

    @GET("/api/")
    Call<RequestResponse> getUserList(@Query("results") String results,
                                      @Query("inc") String includes);

}
