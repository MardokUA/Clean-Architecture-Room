package com.example.developer.roomexample.userlist;

import com.example.developer.roomexample.R;
import com.example.developer.roomexample.UseCase;
import com.example.developer.roomexample.data.source.model.Error;
import com.example.developer.roomexample.userlist.domain.usecase.GetUserList;

public class UserListPresenterImp implements UserListContract.Presenter {

    private UserListContract.View mView;
    private boolean mIsRefresh;

    UserListPresenterImp(UserListContract.View view) {
        mView = view;
    }

    @Override
    public void getUserList() {
        GetUserList getUserListUseCase = new GetUserList();
        getUserListUseCase.execute(new GetUserList.RequestValues(25), new UseCase.UseCaseCallback<GetUserList.ResponseValues>() {
            @Override
            public void onSuccess(GetUserList.ResponseValues response) {
                if (mView != null) {
                    proceedUserListResponse(response);
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

    private void proceedUserListResponse(GetUserList.ResponseValues response) {
        if (mIsRefresh) {
            mView.updateUserList(response.getResponseList());
            mView.showUserListSnack(R.string.snack_user_list_updated, response.getUserListCount());
            mIsRefresh = false;
        } else {
            mView.showUserList(response.getResponseList());
        }
    }

    @Override
    public void onRefresh() {
        mIsRefresh = true;
        getUserList();
    }

    @Override
    public void onDestroy() {
        mView = null;
    }
}
