package com.example.developer.roomexample.userlist.domain.usecase;

import android.support.annotation.NonNull;

import com.example.developer.roomexample.UseCase;
import com.example.developer.roomexample.data.source.UserDataSource;
import com.example.developer.roomexample.data.source.UserRepository;
import com.example.developer.roomexample.data.source.model.Error;
import com.example.developer.roomexample.data.source.model.User;

import java.util.List;

public class GetUserList implements UseCase<GetUserList.RequestValues, GetUserList.ResponseValues> {

    private UserRepository mUserRepository;

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
                ResponseValues responseValues = new ResponseValues(userList);
                callback.onSuccess(responseValues);
            }

            @Override
            public void onError(Error error) {
                callback.onError(error);
            }
        });
    }

    public static class RequestValues implements UseCase.RequestValues {

        private final String mParams = "gender,name,login,email,phone";
        private final Integer mResultCount;

        public RequestValues(@NonNull Integer mResult) {
            this.mResultCount = mResult;
        }

        public String getParams() {
            return mParams;
        }

        public Integer getResultCount() {
            return mResultCount;
        }
    }

    public static class ResponseValues implements UseCase.ResponseValues {

        private final List<User> mResponseList;

        public ResponseValues(List<User> mResponseList) {
            this.mResponseList = mResponseList;
        }

        public List<User> getResponseList() {
            return mResponseList;
        }
    }
}
