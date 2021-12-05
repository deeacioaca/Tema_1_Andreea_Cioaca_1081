package com.example.tema_dam_andreea_cioaca_1081;

import android.content.Context;

import androidx.room.Room;

public class Database {
    private static Database database;
    private DatabaseUser databaseUser;
    private DatabaseTrackingCategory databaseTrackingCategory;

    private Database(Context context){
        databaseUser = Room.databaseBuilder(context,
                DatabaseUser.class, "user-database").build();
        databaseTrackingCategory = Room.databaseBuilder(context,
                DatabaseTrackingCategory.class, "category-database").build();
    }

    public static Database getInstance(Context context){
        if(database == null){
            database = new Database(context);
        }
        return database;
    }

    public DatabaseUser getDatabaseUser(){
        return databaseUser;
    }

    public DatabaseTrackingCategory getDatabaseTrackingCategory(){
        return databaseTrackingCategory;
    }
}
