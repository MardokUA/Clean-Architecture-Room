package com.example.developer.roomexample.data.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLogin {

    @Expose
    @SerializedName("username")
    private String mUserName;
    @Expose
    @SerializedName("password")
    private String mUserPassword;
    @Expose
    @SerializedName("sha1")
    private String mSha1;

    public UserLogin() {
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmUserPassword() {
        return mUserPassword;
    }

    public void setmUserPassword(String mUserPassword) {
        this.mUserPassword = mUserPassword;
    }

    public String getmSha1() {
        return mSha1;
    }

    public void setmSha1(String mSha1) {
        this.mSha1 = mSha1;
    }
}
