package com.example.developer.roomexample.userlist;

import android.support.annotation.StringRes;

import com.example.developer.roomexample.BasePresenter;
import com.example.developer.roomexample.BaseView;
import com.example.developer.roomexample.data.source.model.User;
import com.example.developer.roomexample.userlist.domain.model.UserContact;

import java.util.List;

public interface UserListContract {

    interface Presenter extends BasePresenter {

        void getUserList();

        void onRefresh();
    }

    interface View extends BaseView {

        void showUserList(List<UserContact> userList);

        void showUserListSnack(@StringRes int messageId, String count);

        void updateUserList(List<UserContact> userList);
    }
}
