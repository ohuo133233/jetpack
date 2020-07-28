package com.example.room_java.user;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

public class BaseDataHelp {

    private UserDataBase mUserDataBase;

    private BaseDataHelp() {

    }

    public static BaseDataHelp getInstance() {
        return DataBaseHelpHolder.sInstance;
    }

    private static class DataBaseHelpHolder {
        private static final BaseDataHelp sInstance = new BaseDataHelp();

    }

    public RoomDatabase init(Context context) {
        return mUserDataBase = Room.databaseBuilder(context.getApplicationContext(),
                UserDataBase.class, "database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    public void queryAll() {
        mUserDataBase.userDao().queryAll();
    }


}
