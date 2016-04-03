package com.majorscreations.kindergartenapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Launch_Screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch__screen);

        final TextView newUser = (TextView)findViewById(R.id.newUser);

        final TextView returningUser = (TextView)findViewById(R.id.returningUser);

        final EditText newUserName = (EditText)findViewById(R.id.newUserName);

        final EditText returningUserEmail = (EditText)findViewById(R.id.returningUserEmail);

        final Button submitNewUser = (Button)findViewById(R.id.submitNewUser);
        submitNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Launch_Screen.this, login.class));


                finish();
                startActivity(new Intent(Launch_Screen.this, login.class));


            }
        });

        final Button submitReturningUser = (Button)findViewById(R.id.submitReturningUser);
        submitReturningUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                finish();

                startActivity(new Intent(Launch_Screen.this, login.class));

            }
        });

        Button newuser_button = (Button)findViewById(R.id.newuser_button);
        newuser_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                newUser.setVisibility(View.VISIBLE);
                newUserName.setVisibility(View.VISIBLE);
                submitNewUser.setVisibility(View.VISIBLE);
            }
        });

        Button returninguser_button = (Button)findViewById(R.id.returninguser_button);
        returninguser_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                returningUser.setVisibility(View.VISIBLE);
                returningUserEmail.setVisibility(View.VISIBLE);
                submitReturningUser.setVisibility(View.VISIBLE);
            }
        });


    }
}
