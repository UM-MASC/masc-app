package com.example.project1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText e1, e2;
    Button b1,b2;
    private TextView mTextMessage;
//    Patient patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.navigation_home:
                        Intent i1 = new Intent(LoginActivity.this,MainActivity.class);
                        startActivity(i1);
                        break;
                    case R.id.navigation_emotion_tracking:
                        Intent i2 = new Intent(LoginActivity.this,emotionActivity.class);
                        startActivity(i2);
                        break;
                    case R.id.navigation_schedule_appointment:
                        Intent i3 = new Intent(LoginActivity.this,scheduleActivity.class);
                        startActivity(i3);
                        break;
                }
                return true;
            }
        });
        //finish

        db = new DatabaseHelper(this);
        e1 = (EditText)findViewById(R.id.login_email);
        e2 = (EditText)findViewById(R.id.login_password);
        b1 = (Button)findViewById(R.id.login_button);
        b2 = (Button)findViewById(R.id.registerButton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = e1.getText().toString();
                String password = e2.getText().toString();
                Boolean checkEmail = db.verifyAccount(email,password);
//                Boolean checkEmail2 = db.verifyAccount2(email,password);
//                if (checkEmail ==true || checkEmail2 == true) {
                    if (checkEmail) {
                        User.getInstance().setUserType("Patient");
                        User.getInstance().setEmail(email);
                        Toast.makeText(getApplicationContext(), User.getInstance().getEmail() + User.getInstance().getUserType(), Toast.LENGTH_SHORT).show();
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                        Intent myIntent = new Intent(LoginActivity.this, emotionActivity.class);
                        startActivity(myIntent);
                    }
//                    else if (checkEmail2) {
//                        User.getInstance().setUserType("Caregiver");
//                        User.getInstance().setEmail(email);
//                        Toast.makeText(getApplicationContext(), User.getInstance().getEmail()+ User.getInstance().getUserType(), Toast.LENGTH_SHORT).show();
//                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
//                        Intent myIntent = new Intent(LoginActivity.this, emotionActivity.class);
//                        startActivity(myIntent);
//                    }

                else{
                    Toast.makeText(getApplicationContext(), "Wrong Email or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mTextMessage = (TextView) findViewById(R.id.message);
    }
}
