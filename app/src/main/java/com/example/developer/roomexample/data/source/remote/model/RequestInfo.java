package com.example.developer.roomexample.data.source.remote.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RequestInfo {
    @Expose
    @SerializedName("seed")
    private String mSeed;
    @Expose
    @SerializedName("results")
    private String mResults;
    @Expose
    @SerializedName("page")
    private String mPage;
    @Expose
    @SerializedName("version")
    private String mVersion;
}
