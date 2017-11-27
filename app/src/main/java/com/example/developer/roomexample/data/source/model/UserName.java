package com.example.developer.roomexample.data.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserName {

    @Expose
    @SerializedName("first")
    private String mFirstName;
    @Expose
    @SerializedName("last")
    private String mLastName;

    public UserName() {
    }

    public String getmFirstName() {
        return mFirstName;
    }

    public void setFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String mLastName) {
        this.mLastName = mLastName;
    }
}
