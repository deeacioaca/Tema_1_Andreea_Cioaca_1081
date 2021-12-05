package com.example.tema_dam_andreea_cioaca_1081;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... user);

    @Delete
    void delete(User user);

    @Query("SELECT * FROM user")
    public List<User> getAll();

    @Query("SELECT * FROM user WHERE name == :name")
    public List<User> getUserByName(String name);
}
