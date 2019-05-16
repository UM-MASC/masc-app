package com.example.project1;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class FAQ extends AppCompatActivity {

    private static final String TAG = "MainActivity";


    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        //Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        Intent i1 = new Intent(FAQ.this,MainActivity.class);
                        startActivity(i1);
                        break;
                    case R.id.navigation_emotion_tracking:
                        Intent i2 = new Intent(FAQ.this,emotionActivity.class);
                        startActivity(i2);
                        break;
                    case R.id.navigation_schedule_appointment:
                        Intent i3 = new Intent(FAQ.this,viewEventActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.nagivation_event_assessment:
                        Intent i4 = new Intent(FAQ.this, eventAssessment.class);
                        startActivity(i4);
                        break;
                    case R.id.navigation_faq:
                        Intent i5 = new Intent(FAQ.this,FAQ.class);
                        startActivity(i5);
                        break;
                }
                return true;
            }
        });
        //finish

        initImageBitmaps();
    }



    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://media.istockphoto.com/photos/letter-q-3d-metal-isolated-on-white-picture-id675661888?s=2048x2048");
        mNames.add("How do I schedule an appointment?");

        mImageUrls.add("https://media.istockphoto.com/photos/letter-q-3d-metal-isolated-on-white-picture-id675661888?s=2048x2048");
        mNames.add("How can I make changes to an appointment?");

        mImageUrls.add("https://media.istockphoto.com/photos/letter-q-3d-metal-isolated-on-white-picture-id675661888?s=2048x2048");
        mNames.add("Is my privacy secure when I am using this app?");

        mImageUrls.add("https://media.istockphoto.com/photos/letter-q-3d-metal-isolated-on-white-picture-id675661888?s=2048x2048");
        mNames.add("How will this app improve my emotional health?");

        mImageUrls.add("https://media.istockphoto.com/photos/letter-q-3d-metal-isolated-on-white-picture-id675661888?s=2048x2048");
        mNames.add("Question 5");

        mImageUrls.add("https://media.istockphoto.com/photos/letter-q-3d-metal-isolated-on-white-picture-id675661888?s=2048x2048");
        mNames.add("Question 6");

        mImageUrls.add("https://media.istockphoto.com/photos/letter-q-3d-metal-isolated-on-white-picture-id675661888?s=2048x2048");
        mNames.add("Question 7");

        mImageUrls.add("https://media.istockphoto.com/photos/letter-q-3d-metal-isolated-on-white-picture-id675661888?s=2048x2048");
        mNames.add("Question 8");



        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        com.example.project1.RecyclerViewAdapter adapter = new com.example.project1.RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}