package com.majorscreations.kindergartenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        ImageView imgRotate = (ImageView)findViewById(R.id.imageView);
        imgRotate.startAnimation(AnimationUtils.loadAnimation(this, R.anim.anim));

        TimerTask task = new TimerTask(){
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, Launch_Screen.class);
                startActivity(intent);
                finish();

            }

        };
        Timer opening = new Timer();
        opening.schedule(task, 2500);


    }
}
