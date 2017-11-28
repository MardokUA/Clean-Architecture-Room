package com.example.developer.roomexample.userlist.domain.usecase;

import com.example.developer.roomexample.data.source.UserDataSource;
import com.example.developer.roomexample.data.source.UserRepository;
import com.example.developer.roomexample.data.source.local.entity.UserContact;
import com.example.developer.roomexample.data.source.remote.model.Error;

import java.util.List;

public class UpdateUserList extends GetUserList {

    private UserRepository mUserRepository;

    public UpdateUserList() {
        mUserRepository = UserRepository.getInstance();
    }

    @Override
    public void execute(RequestValues values, final UseCaseCallback<ResponseValues> callback) {
        String resultCount = String.valueOf(values.getResultCount());
        String params = values.getParams();
        mUserRepository.updateUserList(resultCount, params, new UserDataSource.BaseSourceCallback() {
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
}
