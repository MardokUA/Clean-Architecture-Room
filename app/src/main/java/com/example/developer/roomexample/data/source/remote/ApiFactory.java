package com.example.developer.roomexample.data.source.remote;

import com.example.developer.roomexample.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static ApiFactory INSTANCE;

    private Retrofit mRetrofit;

    public static ApiFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ApiFactory();
        }
        return INSTANCE;
    }

    private ApiFactory() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(interceptor);

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
