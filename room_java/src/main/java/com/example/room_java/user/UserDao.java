package com.example.room_java.user;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {


    @Query("SELECT * FROM User")
    List<User> queryAll();

    @Insert
    void insertAll(User... User);

    @Delete
    void delete(User... User);

}
