package com.example.room_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.room_java.user.BaseDataHelp;
import com.example.room_java.user.User;
import com.example.room_java.user.UserDataBase;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mQuery;
    private Button mInsert;
    private Button mDelete;
    private UserDataBase mUserDataBase;
    private User mUser1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseDataHelp.getInstance().init(this);
        mQuery = findViewById(R.id.query);
        mInsert = findViewById(R.id.insert);
        mDelete = findViewById(R.id.delete);
        mQuery.setOnClickListener(this);
        mInsert.setOnClickListener(this);
        mDelete.setOnClickListener(this);
        mUserDataBase = (UserDataBase) BaseDataHelp.getInstance().init(this);
        User user = new User();
        user.setName("wang");
        user.setAddress("wang");
        mUserDataBase.userDao().insertAll(user);
        mUser1 = new User();
        mUser1.setName("wang");
        mUser1.setAddress("wang");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.query:
                List<User> users = mUserDataBase.userDao().queryAll();
                Log.e("TAG", "users查询结果： " + users.toString());
                break;
            case R.id.insert:
                mUserDataBase.userDao().insertAll(mUser1);
                List<User> users1 = mUserDataBase.userDao().queryAll();
                Log.e("TAG", "users添加后查询结果： " + users1.toString());
                break;
            case R.id.delete:
                mUserDataBase.userDao().delete(mUser1);
                List<User> users2 = mUserDataBase.userDao().queryAll();
                Log.e("TAG", "users删除后查询结果： " + users2.toString());
                break;
        }
    }
}
