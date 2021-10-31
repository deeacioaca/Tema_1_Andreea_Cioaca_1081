package com.example.tema_dam_andreea_cioaca_1081;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrackingList extends AppCompatActivity {
    private ListView listView;
    private TrackingAdapter trackingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_list);

        trackingAdapter = new TrackingAdapter(getCategories());
        listView = findViewById(R.id.ListView);
        listView.setAdapter(trackingAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Random random = new Random(1);
                int randomInt = random.nextInt();
                if(randomInt % 2 == 0)
                    trackingAdapter.updateList(getCategories());
                else
                    trackingAdapter.updateList(getCategories2());
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                TrackingCategory category = trackingAdapter.getItem(position);
                Toast.makeText(TrackingList.this, category.toString(), Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }

    private List<TrackingCategory> getCategories(){
        List<TrackingCategory> list = new ArrayList<>();
        list.add(new TrackingCategory("Period", "Bleeding", "Collection Method", "Longer than usual"));
        list.add(new TrackingCategory("Body", "Craving", "Digestion", "Fluid"));
        list.add(new TrackingCategory("Vitality", "Emotions", "Energy", "Mental"));
        list.add(new TrackingCategory("Activities", "Appointment", "Exercise", "Meditation"));
        list.add(new TrackingCategory("Medical", "Injection", "Medication", "Pill"));
        list.add(new TrackingCategory("Pain", "Head", "Stomach", "Back"));
        return list;
    }

    private List<TrackingCategory> getCategories2(){
        List<TrackingCategory> list = new ArrayList<>();
        list.add(new TrackingCategory("Activities", "Appointment", "Exercise", "Meditation"));
        list.add(new TrackingCategory("Medical", "Injection", "Medication", "Pill"));
        list.add(new TrackingCategory("Pain", "Head", "Stomach", "Back"));
        list.add(new TrackingCategory("Period", "Bleeding", "Collection Method", "Longer than usual"));
        list.add(new TrackingCategory("Body", "Craving", "Digestion", "Fluid"));
        list.add(new TrackingCategory("Vitality", "Emotions", "Energy", "Mental"));
        return list;
    }
}
