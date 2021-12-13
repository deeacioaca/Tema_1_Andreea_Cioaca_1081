package com.example.tema_dam_andreea_cioaca_1081;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TrackingList extends AppCompatActivity {

    private ListView listView;
    private TrackingAdapter trackingAdapter;
    private TrackingCategoryDAO trackingCategoryDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_list);

        trackingAdapter = new TrackingAdapter(getCategories());
        listView = findViewById(R.id.ListView);
        listView.setAdapter(trackingAdapter);
        listView.setVisibility(View.VISIBLE);


//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Random random = new Random(1);
//                int randomInt = random.nextInt();
//                if(randomInt % 2 == 0)
//                    trackingAdapter.updateList(getCategories());
//                else
//                    trackingAdapter.updateList(getCategories2());
//            }
//        });
//
//        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
//            @Override
//            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
//                TrackingCategory category = trackingAdapter.getItem(position);
//                Toast.makeText(TrackingList.this, category.toString(), Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });

//        JSONReader reader = new JSONReader();
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                reader.read("https://jsonkeeper.com/b/EL09", new IResponse() {
//                    @Override
//                    public void onSuccess(List<TrackingCategory> list) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
////                                Toast.makeText(TrackingList.this, list.toString(), Toast.LENGTH_SHORT).show();
//                                trackingAdapter.updateList(list);
//                            }
//                        });
//                    }
//
//                    @Override
//                    public void onError(String mesaj) {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Toast.makeText(TrackingList.this, mesaj, Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                    }
//                });
//            }
//        });
//        thread.start();

        writeToDatabase();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                TrackingCategoryDAO trackingCategoryDAO = Database.getInstance(TrackingList.this).getDatabaseTrackingCategory().trackingCategoryDAO();
                List<TrackingCategory> list = getCategories();
                for (int i = 0; i < list.size(); i++) {
                    trackingCategoryDAO.insertAll(list.get(i));
                }
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("Tracking Categories");
                for (int i = 0; i < list.size(); i++) {
                    int j = i;
                    myRef.child(Integer.toString(j)).setValue(list.get(j).toString());
                }
            }
        });
        thread2.start();
        readFromDatabase();
    }

    private List<TrackingCategory> getCategories() {
        List<TrackingCategory> list = new ArrayList<>();

        list.add(new TrackingCategory("Period", "Bleeding", "Collection Method", "Longer than usual"));
        list.add(new TrackingCategory("Body", "Craving", "Digestion", "Fluid"));
        list.add(new TrackingCategory("Vitality", "Emotions", "Energy", "Mental"));
        list.add(new TrackingCategory("Activities", "Emotions", "Appointment", "Exercise"));
        list.add(new TrackingCategory("Medical", "Injection", "Medication", "Pill"));
        list.add(new TrackingCategory("Pain", "Head", "Stomach", "Back"));
        return list;
    }

//    private List<TrackingCategory> getCategories2(){
//        List<TrackingCategory> list = new ArrayList<>();
//        list.add(new TrackingCategory("Activities", "Appointment", "Exercise", "Meditation"));
//        list.add(new TrackingCategory("Medical", "Injection", "Medication", "Pill"));
//        list.add(new TrackingCategory("Pain", "Head", "Stomach", "Back"));
//        list.add(new TrackingCategory("Period", "Bleeding", "Collection Method", "Longer than usual"));
//        list.add(new TrackingCategory("Body", "Craving", "Digestion", "Fluid"));
//        list.add(new TrackingCategory("Vitality", "Emotions", "Energy", "Mental"));
//        return list;
//    }

    public void writeToDatabase() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello!");
    }

    public void readFromDatabase() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Tracking Categories");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    String value = dataSnapshot1.getValue(String.class);
                    Log.d("read", "Value is: " + value);
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("cancel", "Failed to read value.", error.toException());
            }
        });
    }

}

