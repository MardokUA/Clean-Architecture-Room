package com.example.developer.roomexample.userlist;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import com.example.developer.roomexample.R;
import com.example.developer.roomexample.application.RoomExample;
import com.example.developer.roomexample.userlist.domain.model.UserContact;

import java.util.List;

public class UserListActivity extends AppCompatActivity implements UserListContract.View {

    private UserListPresenterImp mPresenter;
    private UserListAdapter mAdapter;
    private SwipeRefreshLayout mRefreshLayout;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        if (RoomExample.isKitkat()) {
            setTheme(R.style.ActivityKitKatTheme);
        }
        initViewContent();
        initAdapter();
        initPresenter();
    }

    private void initViewContent() {
        Toolbar toolbar = findViewById(R.id.users_toolbar);
        if (getSupportActionBar() != null) {
            setSupportActionBar(toolbar);
        }
        mProgressBar = findViewById(R.id.users_progress_bar);
        mRefreshLayout = findViewById(R.id.users_swipe_refresh);
        mRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorAccent));
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.onRefresh();
            }
        });
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
        mProgressBar.setVisibility(View.GONE);
        mAdapter.updateUserList(userList);
    }

    @Override
    public void showUserListSnack(int messageId, String count) {
        showSnack(getString(messageId) + " " + count);
    }

    @Override
    public void updateUserList(List<UserContact> userList) {
        mRefreshLayout.setRefreshing(false);
        mAdapter.updateUserList(userList);
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
