package com.majorscreations.kindergartenapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MathQuestionActivity extends AppCompatActivity {
<<<<<<< HEAD
    int total, right, wrong;
=======
    // List of fragments handled for this app

    ArrangeNumbersOneToFiveFragment arrangeGameFragment;
>>>>>>> 72e23ea774b427bcba946b4d06f056aeef7cd9ea

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_question);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        arrangeGameFragment = new ArrangeNumbersOneToFiveFragment();
        transaction.replace(android.R.id.content, arrangeGameFragment);
        transaction.commit();
    }

}
