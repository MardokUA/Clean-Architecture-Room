package com.example.developer.roomexample.userlist.domain.usecase;

import android.support.annotation.NonNull;

import com.example.developer.roomexample.UseCase;
import com.example.developer.roomexample.data.source.UserDataSource;
import com.example.developer.roomexample.data.source.UserRepository;
import com.example.developer.roomexample.data.source.local.entity.UserContact;
import com.example.developer.roomexample.data.source.mapper.UserContactMapper;
import com.example.developer.roomexample.data.source.remote.model.Error;
import com.example.developer.roomexample.data.source.remote.model.User;

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

        mUserRepository.getUserList(resultCount, params, new UserDataSource.BaseSourceCallback() {
            @Override
            public void onSuccess(List<UserContact> userList) {
                GetUserList.ResponseValues response = new GetUserList.ResponseValues(userList);
                callback.onSuccess(response);
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
