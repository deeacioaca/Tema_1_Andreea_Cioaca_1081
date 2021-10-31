package com.example.tema_dam_andreea_cioaca_1081;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

public class TrackingAdapter extends BaseAdapter {

    private List<TrackingCategory> list;

    public TrackingAdapter(List<TrackingCategory> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public TrackingCategory getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        @SuppressLint("ViewHolder")
        View view = inflater.inflate(R.layout.item_category, parent, false);
        TextView tCategoryName = view.findViewById(R.id.categoryName);
        Switch symptom1 = view.findViewById(R.id.symptom1);
        Switch symptom2 = view.findViewById(R.id.symptom2);
        Switch symptom3 = view.findViewById(R.id.symptom3);
        TrackingCategory category = list.get(position);
        tCategoryName.setText(category.getCategoryName());
        symptom1.setText(category.getSymptom1());
        symptom2.setText(category.getSymptom2());
        symptom3.setText(category.getSymptom3());
        return view;
    }

    public void updateList(List<TrackingCategory> newList){
        this.list.clear();
        this.list.addAll(newList);
        notifyDataSetChanged();
    }
}
