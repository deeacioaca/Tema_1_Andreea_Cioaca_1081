package com.example.tema_dam_andreea_cioaca_1081;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TrackingCategoryDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(TrackingCategory... trackingCategory);

    @Delete
    void delete(TrackingCategory trackingCategory);

    @Query("SELECT * FROM tracking_category")
    public List<TrackingCategory> getAll();

    @Query("SELECT * FROM tracking_category WHERE symptom_1 = :symptom")
    public List<TrackingCategory> getCategoryBySymptoms (String symptom);
}