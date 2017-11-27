package com.example.developer.roomexample.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.developer.roomexample.userlist.domain.model.UserContact;

@Database(entities = {UserContact.class}, version = 1)
public abstract class UserLocalDataBase extends RoomDatabase {
    public abstract UserDao getUserDao();
}
