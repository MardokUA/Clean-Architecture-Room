package com.example.developer.roomexample.userlist;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.example.developer.roomexample.R;
import com.example.developer.roomexample.data.source.model.User;
import com.example.developer.roomexample.userlist.domain.model.UserContact;

import java.util.List;

public class UserListActivity extends AppCompatActivity implements UserListContract.View {

    private UserListPresenterImp mPresenter;
    private UserListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        Toolbar toolbar = findViewById(R.id.users_toolbar);
        if (getSupportActionBar() != null) {
            setSupportActionBar(toolbar);
        }
        initAdapter();
        initPresenter();
    }

    private void initAdapter() {
        mAdapter = new UserListAdapter(this);
        RecyclerView recyclerView = findViewById(R.id.users_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);
    }

    private void initPresenter() {
        mPresenter = new UserListPresenterImp(this);
        mPresenter.getUserList();
    }

    @Override
    public void showUserList(List<UserContact> userList) {
        mAdapter.updateUserList(userList);
    }

    @Override
    public void showUserListSnack(int messageId, String count) {
        showSnack(getString(messageId) + " " + count);
    }

    @Override
    public void updateUserList(List<User> userList) {

    }

    @Override
    public void showMessage(@StringRes int messageId) {
        showSnack(getString(messageId));
    }

    @Override
    public void showError(String message) {
        showSnack(message);
    }

    private void showSnack(String message) {
        Snackbar.make(findViewById(R.id.users_container), message, Snackbar.LENGTH_SHORT).show();
    }
}
