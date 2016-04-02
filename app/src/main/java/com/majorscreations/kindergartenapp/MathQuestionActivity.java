package com.majorscreations.kindergartenapp;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MathQuestionActivity extends AppCompatActivity {

    int total, right, wrong;

    final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
    // List of fragments handled for this app

    ArrangeNumbersOneToFiveFragment arrangeGameFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_question);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("key5", right);
        editor.putInt("key6", wrong);
        editor.putInt("key7", total);
        editor.commit();


        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        arrangeGameFragment = new ArrangeNumbersOneToFiveFragment();
        transaction.replace(android.R.id.content, arrangeGameFragment);
        transaction.commit();


    }

}
