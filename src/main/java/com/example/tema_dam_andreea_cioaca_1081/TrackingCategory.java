package com.example.tema_dam_andreea_cioaca_1081;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tracking_category")
public class TrackingCategory {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "category_name")
    private String categoryName;

    @ColumnInfo(name = "symptom_1")
    private String symptom1;

    @ColumnInfo(name = "symptom_2")
    private String symptom2;

    @ColumnInfo(name = "symptom_3")
    private String symptom3;

    public TrackingCategory(String categoryName, String symptom1, String symptom2, String symptom3) {
        this.categoryName = categoryName;
        this.symptom1 = symptom1;
        this.symptom2 = symptom2;
        this.symptom3 = symptom3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getSymptom1() {
        return symptom1;
    }

    public void setSymptom1(String symptom1) {
        this.symptom1 = symptom1;
    }

    public String getSymptom2() {
        return symptom2;
    }

    public void setSymptom2(String symptom2) {
        this.symptom2 = symptom2;
    }

    public String getSymptom3() {
        return symptom3;
    }

    public void setSymptom3(String symptom3) {
        this.symptom3 = symptom3;
    }

    @Override
    public String toString() {
        return "TrackingCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", symptom1='" + symptom1 + '\'' +
                ", symptom2='" + symptom2 + '\'' +
                ", symptom3='" + symptom3 + '\'' +
                '}';
    }
}
