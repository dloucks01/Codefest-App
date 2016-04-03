package com.majorscreations.kindergartenapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.Arrays;

public class StatisticsWebView extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_web_view);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final Integer Total = sharedPref.getInt("key7", 0);
        final Float Average = sharedPref.getFloat("key8", 0);
        final Integer Correct = sharedPref.getInt("key5", 0);
        final Integer Incorrect = sharedPref.getInt("key6", 0);


        }
    }
