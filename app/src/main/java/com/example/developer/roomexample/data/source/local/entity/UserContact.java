package com.example.developer.roomexample.data.source.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class UserContact {
    @PrimaryKey
    @NonNull
    private String mId;
    @ColumnInfo(name = "name")
    private String mUserWholeName;
    @ColumnInfo(name = "login")
    private String mLogin;
    @ColumnInfo(name = "password")
    private String mPassword;
    @ColumnInfo(name = "email")
    private String mEmail;
    @ColumnInfo(name = "phone")
    private String mPhone;
    @ColumnInfo(name = "gender")
    private String mGender;
    @ColumnInfo(name = "sha1")
    private String mSha1;

    public UserContact() {
    }

    public UserContact(String firstName, String lastName) {
        String firstNameBigLetter = firstName.substring(0, 1).toUpperCase();
        String lastNameBigLetter = lastName.substring(0, 1).toUpperCase();
        mUserWholeName = firstNameBigLetter + firstName.substring(1) + " " + lastNameBigLetter + lastName.substring(1);
    }

    public String getId() {
        return mId;
    }

    public void setId(String mId) {
        this.mId = mId;
    }

    public String getUserWholeName() {
        return mUserWholeName;
    }

    public void setUserWholeName(String mUserWholeName) {
        this.mUserWholeName = mUserWholeName;
    }

    public String getLogin() {
        return mLogin;
    }

    public void setLogin(String mLogin) {
        this.mLogin = mLogin;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String mPassword) {
        this.mPassword = mPassword;
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

    public String getGender() {
        return mGender;
    }

    public void setGender(String mGender) {
        this.mGender = mGender;
    }

    public String getSha1() {
        return mSha1;
    }

    public void setSha1(String mSha1) {
        this.mSha1 = mSha1;
    }

}
