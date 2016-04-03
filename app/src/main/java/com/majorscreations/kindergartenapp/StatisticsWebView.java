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

        WebView web = (WebView)findViewById(R.id.webView);

        switch(Correct)
        {
            case 0:
                web.loadDataWithBaseURL("file:///android_asset/", "<img src='zerocorrect.PNG' />", "text/html", "utf-8", null);
                break;
            case 1:
                web.loadDataWithBaseURL("file:///android_asset/", "<img src='onecorrect.PNG' />", "text/html", "utf-8", null);
                break;
            case 2:
                web.loadDataWithBaseURL("file:///android_asset/", "<img src='twocorrect.PNG' />", "text/html", "utf-8", null);
                break;
            case 3:
                web.loadDataWithBaseURL("file:///android_asset/", "<img src='threecorrect.PNG' />", "text/html", "utf-8", null);
                break;
        }

        }
    }
