package com.example.project1.onboarding.component;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.project1.R;
import com.example.project1.emotionAssessment.EmotionAssessmentActivity;
import com.example.project1.login.LoginActivity;
import com.example.project1.login.component.SessionManager;

public class OnboardingQuestionnaireFragment extends Fragment {
    SessionManager sessionManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        sessionManager = new SessionManager(getContext());
        sessionManager.checkLogin();

        View thisFragment = inflater.inflate(R.layout.fragment_onboarding_questionnaire, container, false);

        return thisFragment;
    }
}
