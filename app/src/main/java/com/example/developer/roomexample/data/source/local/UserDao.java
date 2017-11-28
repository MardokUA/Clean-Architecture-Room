package com.example.developer.roomexample.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.developer.roomexample.data.source.local.entity.UserContact;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertAll(UserContact... userContacts);

    @Delete
    void deleteContact(UserContact userContact);

    @Query("SELECT * FROM users")
    List<UserContact> getAllUsers();

}
