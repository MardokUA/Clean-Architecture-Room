package com.example.developer.roomexample.data.source.local;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.developer.roomexample.userlist.domain.model.UserContact;

import java.util.List;

public interface UserDao {

    @Insert
    void insertAll(UserContact... userContacts);

    @Delete
    void deleteContact();

    @Query("SELECT * FROM users")
    List<UserContact> getAllUsers();

}
