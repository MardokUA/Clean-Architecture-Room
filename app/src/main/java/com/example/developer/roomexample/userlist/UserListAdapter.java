package com.example.developer.roomexample.userlist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.developer.roomexample.R;
import com.example.developer.roomexample.data.source.local.entity.UserContact;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {

    private List<UserContact> mUserList;
    private final LayoutInflater mInflater;

    UserListAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mUserList = new ArrayList<>();
    }

    @Override
    public UserListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = mInflater.inflate(R.layout.item_user, parent, false);
        return new UserListViewHolder(root);
    }

    @Override
    public void onBindViewHolder(UserListViewHolder holder, int position) {
        UserContact userContact = mUserList.get(position);
        holder.mUserName.setText(userContact.getUserWholeName());
        holder.mUserLogin.setText(userContact.getLogin());
        holder.mUserPassword.setText(userContact.getPassword());
        holder.mUserEmail.setText(userContact.getEmail());
        holder.mUserPhone.setText(userContact.getPhone());
        holder.mUserGender.setText(userContact.getGender());
        holder.mUserSha1.setText(userContact.getSha1());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    void updateUserList(List<UserContact> userList) {
        mUserList.clear();
        mUserList.addAll(userList);
        notifyDataSetChanged();
    }

    class UserListViewHolder extends RecyclerView.ViewHolder {

        private TextView mUserName;
        private TextView mUserLogin;
        private TextView mUserPassword;
        private TextView mUserEmail;
        private TextView mUserPhone;
        private TextView mUserGender;
        private TextView mUserSha1;

        UserListViewHolder(View rootView) {
            super(rootView);
            mUserName = rootView.findViewById(R.id.user_name);
            mUserLogin = rootView.findViewById(R.id.user_login_value);
            mUserPassword = rootView.findViewById(R.id.user_password_value);
            mUserEmail = rootView.findViewById(R.id.user_email_value);
            mUserPhone = rootView.findViewById(R.id.user_phone_value);
            mUserGender = rootView.findViewById(R.id.user_gender_value);
            mUserSha1 = rootView.findViewById(R.id.user_sha1_value);
        }
    }
}
