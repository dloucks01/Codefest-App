package com.majorscreations.kindergartenapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MathQuestionActivity extends AppCompatActivity {
    int total, right, wrong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_question);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        ArrangeNumbersOneToFiveFragment gameArrange = new ArrangeNumbersOneToFiveFragment();
        transaction.replace(android.R.id.content, gameArrange);
        transaction.commit();
    }
}
