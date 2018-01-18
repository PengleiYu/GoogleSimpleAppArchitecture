package com.example.apparchitecture.room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by yupenglei on 18/1/18.
 */

@Dao
public interface UserDao {
    @Query("select * from user")
    List<User> getAll();

    @Query("select * from user where uid in (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("select * from user where fist_name like :first and last_name like :last limit 1")
    User findByName(String first, String last);

    @Insert
    void insertAll(User... users);

    @Delete
    void delete(User user);
}
