package com.example.developer.roomexample.userlist.domain.usecase;

import android.support.annotation.NonNull;

import com.example.developer.roomexample.UseCase;
import com.example.developer.roomexample.data.source.UserDataSource;
import com.example.developer.roomexample.data.source.UserRepository;
import com.example.developer.roomexample.data.source.model.Error;
import com.example.developer.roomexample.data.source.model.User;
import com.example.developer.roomexample.userlist.domain.model.UserContact;

import java.util.ArrayList;
import java.util.List;

public class GetUserList implements UseCase<GetUserList.RequestValues, GetUserList.ResponseValues> {

    private UserRepository mUserRepository;
    private final String mUnrecognized = "unrecognized";

    public GetUserList() {
        mUserRepository = UserRepository.getInstance();
    }

    @Override
    public void execute(RequestValues values, final UseCaseCallback<GetUserList.ResponseValues> callback) {
        String resultCount = String.valueOf(values.getResultCount());
        String params = values.getParams();

        mUserRepository.getUserList(resultCount, params, new UserDataSource.SourceCallback() {
            @Override
            public void onSuccess(List<User> userList) {
                List<UserContact> userContacts = generateUserContactList(userList);
                GetUserList.ResponseValues response = new GetUserList.ResponseValues(userContacts);
                callback.onSuccess(response);
            }

            @Override
            public void onError(Error error) {
                callback.onError(error);
            }
        });
    }

    private List<UserContact> generateUserContactList(List<User> userResponseList) {
        List<UserContact> userContacts = new ArrayList<>(25);
        for (User user : userResponseList) {
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
            userContacts.add(userContact);
        }
        return userContacts;
    }

    private String obtainUserFieldData(String param) {
        return param == null ? mUnrecognized : param;
    }

    public static class RequestValues implements UseCase.RequestValues {

        private final String mParams = "gender,name,login,email,phone";
        private final Integer mResultCount;

        public RequestValues(@NonNull Integer mResult) {
            this.mResultCount = mResult;
        }

        String getParams() {
            return mParams;
        }

        Integer getResultCount() {
            return mResultCount;
        }
    }

    public static class ResponseValues implements UseCase.ResponseValues {

        private final List<UserContact> mResponseList;

        ResponseValues(List<UserContact> mResponseList) {
            this.mResponseList = mResponseList;
        }

        public List<UserContact> getResponseList() {
            return mResponseList;
        }

        public String getUserListCount() {
            return String.valueOf(mResponseList.size());
        }
    }
}
