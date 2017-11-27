package com.example.developer.roomexample.data.source.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class RequestResponse {

    @Expose
    @SerializedName("results")
    private List<User> mUserList;
    @Expose
    @SerializedName("info")
    private RequestInfo mUserInfo;

    public RequestResponse() {
    }

    public List<User> getUserList() {
        if (mUserList == null) {
            mUserList = new ArrayList<>(1);
        }
        return mUserList;
    }

    public void setUserList(List<User> mUserList) {
        this.mUserList = mUserList;
    }

    public RequestInfo getUserInfo() {
        return mUserInfo;
    }

    public void setUserInfo(RequestInfo mUserInfo) {
        this.mUserInfo = mUserInfo;
    }
}
