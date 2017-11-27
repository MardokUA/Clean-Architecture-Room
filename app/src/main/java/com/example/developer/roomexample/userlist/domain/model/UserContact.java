package com.example.developer.roomexample.userlist.domain.model;

public class UserContact {

    private String mUserWholeName;
    private String mLogin;
    private String mPassword;
    private String mEmail;
    private String mPhone;
    private String mGender;
    private String mSha1;

    public UserContact(String firstName, String lastName) {
        String firstNameBigLetter = firstName.substring(0, 1).toUpperCase();
        String lastNameBigLetter = lastName.substring(0, 1).toUpperCase();
        mUserWholeName = firstNameBigLetter + firstName.substring(1) + " " + lastNameBigLetter + lastName.substring(1);
    }

    public String getUserWholeName() {
        return mUserWholeName;
    }

    public void setUserWholeName(String mUserWholeNahe) {
        this.mUserWholeName = mUserWholeNahe;
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
