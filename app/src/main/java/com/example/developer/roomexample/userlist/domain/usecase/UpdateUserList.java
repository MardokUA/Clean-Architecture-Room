package com.example.developer.roomexample.userlist.domain.usecase;

import com.example.developer.roomexample.UseCase;
import com.example.developer.roomexample.data.source.UserRepository;

public class UpdateUserList implements UseCase<UpdateUserList.RequestValues, UpdateUserList.ResponseValues> {

    private UserRepository mUserRepository;

    public UpdateUserList() {
        mUserRepository = UserRepository.getInstance();
    }

    @Override
    public void execute(RequestValues values, UseCaseCallback<ResponseValues> callback) {

    }

    public static class RequestValues implements UseCase.RequestValues {

    }

    public static class ResponseValues implements UseCase.ResponseValues {

    }
}
