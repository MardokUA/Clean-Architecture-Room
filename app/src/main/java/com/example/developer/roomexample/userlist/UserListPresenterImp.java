package com.example.developer.roomexample.userlist;

import com.example.developer.roomexample.R;
import com.example.developer.roomexample.UseCase;
import com.example.developer.roomexample.data.source.model.Error;
import com.example.developer.roomexample.userlist.domain.usecase.GetUserList;

public class UserListPresenterImp implements UserListContract.Presenter {

    private UserListContract.View mView;
    private GetUserList mUseCase;

    public UserListPresenterImp(UserListContract.View view) {
        mView = view;
        mUseCase = new GetUserList();
    }

    @Override
    public void getUserList() {
        final GetUserList.RequestValues requestValues = new GetUserList.RequestValues(25);
        mUseCase.execute(requestValues, new UseCase.UseCaseCallback<GetUserList.ResponseValues>() {
            @Override
            public void onSuccess(GetUserList.ResponseValues response) {
                if (mView != null) {
                    mView.showUserList(response.getResponseList());
                    mView.showUserListSnack(R.string.user_list_count, response.getUserListCount());
                }
            }

            @Override
            public void onError(Error error) {
                if (mView != null) {
                    mView.showError(error.getErrorMessage());
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        mView = null;
    }
}
