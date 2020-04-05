package com.example.project1.forum.specialist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.project1.onboarding.OnboardingBaseActivity;
import com.example.project1.questionnaire.QuestionnaireActivity;
import com.example.project1.changePassword.ChangePasswordActivity;
import com.example.project1.emotionAssessment.EmotionAssessmentActivity;
import com.example.project1.faq.FAQActivity;
import com.example.project1.mainPage.MainActivity;
import com.example.project1.R;
import com.example.project1.login.component.SessionManager;
import com.example.project1.login.component.User;
import com.example.project1.userProfile.UserProfileActivity;
import com.example.project1.forum.ForumActivity;
import com.example.project1.forum.caregiver.CaregiverForumActivity;

public class SpecialistForumActivity extends AppCompatActivity {
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialist_forum);
        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();

        //drawer
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Bottom Navigation Bar
        BottomNavigationView bottomNavigationView =
                (BottomNavigationView) findViewById(R.id.navigation);
        if(User.getInstance().getUserType().equals("Admin")){
            bottomNavigationView.setVisibility(View.GONE);
        }
        MenuItem item_exercise = bottomNavigationView.getMenu().findItem(R.id.navigation_exercise);
        item_exercise.setVisible(false);
        MenuItem item = bottomNavigationView.getMenu().findItem(R.id.navigation_forum);
        item.setChecked(true);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_emotion_assessment:
                        Intent i2 = new Intent(SpecialistForumActivity.this,
                                EmotionAssessmentActivity.class);
                        startActivity(i2);
                        break;
                    case R.id.navigation_forum:
                            Intent i6 = new Intent(SpecialistForumActivity.this, SpecialistForumActivity.class);
                            startActivity(i6);
                            break;

                    case R.id.navigation_chat:
                        Intent i=getPackageManager().getLaunchIntentForPackage("com.example.fypchat");
                        startActivity(i);
                        break;
                }
                return true;
            }
        });
    }

    public void onNavPatientForum(View v){
        Intent i = new Intent(SpecialistForumActivity.this, ForumActivity.class);
        startActivity(i);
    }

    public void onNavCaregiverForum(View v){
        Intent i = new Intent(SpecialistForumActivity.this, CaregiverForumActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            sessionManager.logout();
            Intent i = new Intent(SpecialistForumActivity.this, MainActivity.class);
            i.setFlags(i.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            User.getInstance().setUserName("");
            User.getInstance().setEmail("");
            User.getInstance().setUserType("");
//            finish();
            return true;
        }

        if (id == R.id.action_change_password){
            Intent intent = new Intent(SpecialistForumActivity.this, ChangePasswordActivity.class);
            startActivity(intent);
            return true;
        }

        if(id == R.id.action_user_profile){
            Intent intent = new Intent(SpecialistForumActivity.this, UserProfileActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_faq) {
            Intent intent = new Intent(SpecialistForumActivity.this, OnboardingBaseActivity.class);
            startActivity(intent);
            return true;
        }

        if(id == R.id.action_questionnaire){
            Intent intent = new Intent(SpecialistForumActivity.this, QuestionnaireActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
