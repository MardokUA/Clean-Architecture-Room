package com.example.developer.roomexample.data.source.local.mapper;

import com.example.developer.roomexample.data.source.local.entity.UserContact;
import com.example.developer.roomexample.data.source.remote.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserContactMapper {

    private final String mUnrecognized = "unrecognized";

    private List<User> mUserList;

    public UserContactMapper(List<User> userList) {
        mUserList = userList;
    }

    public List<UserContact> transmorph() {
        List<UserContact> userContactList = new ArrayList<>(25);
        for (User user : mUserList) {
            String firstName = obtainUserFieldData(user.getUserName().getFirstName());
            String lastName = obtainUserFieldData(user.getUserName().getLastName());
            UserContact userContact = new UserContact(firstName, lastName);
            userContact.setId(user.getId());
            userContact.setEmail(obtainUserFieldData(user.getEmail()));
            userContact.setGender(obtainUserFieldData(user.getGender()));
            userContact.setPhone(obtainUserFieldData(user.getPhone()));
            userContact.setLogin(obtainUserFieldData(user.getUserLogin().getUserName()));
            userContact.setPassword(obtainUserFieldData(user.getUserLogin().getUserPassword()));
            userContact.setSha1(obtainUserFieldData(user.getUserLogin().getSha1()));
            userContactList.add(userContact);
        }
        return userContactList;
    }

    private String obtainUserFieldData(String param) {
        return param == null ? mUnrecognized : param;
    }
}
