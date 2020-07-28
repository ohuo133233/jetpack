package com.example.room_java.user;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = User.class, version = 1)
public abstract class UserDataBase extends RoomDatabase {
    public abstract UserDao userDao();
}
