package com.example.developer.roomexample.userlist.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.UUID;

public class User {

    @Expose
    @SerializedName("gender")
    private String mGender;
    @Expose
    @SerializedName("name")
    private UserName mUserName;
    @Expose
    @SerializedName("email")
    private String mEmail;
    @Expose
    @SerializedName("phone")
    private String mPhone;

    private String mId;

    public User() {
    }

    public String getGender() {
        return mGender;
    }

    public void setGender(String mGender) {
        this.mGender = mGender;
    }

    public UserName getUserName() {
        return mUserName;
    }

    public void setUserName(UserName mUserName) {
        this.mUserName = mUserName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String mPhone) {
        this.mPhone = mPhone;
    }

    public String getId() {
        if (mId == null) {
            mId = UUID.randomUUID().toString();
        }
        return mId;
    }
}
