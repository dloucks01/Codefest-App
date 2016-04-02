package com.majorscreations.kindergartenapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class login extends AppCompatActivity {
    String email1, childName, dob1, parentName1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText name = (EditText) findViewById(R.id.getName);
        final EditText email = (EditText) findViewById(R.id.getEmail);
        final EditText dob = (EditText)findViewById(R.id.editTextdob);
        final EditText parentsName = (EditText)findViewById(R.id.editTextParentName);

        Button login = (Button) findViewById(R.id.btnLogin);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email1 = (email.getText().toString());
                childName = (name.getText().toString());
                dob1 = (dob.getText().toString());
                parentName1 = (parentsName.getText().toString());

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("key1", email1);
                editor.putString("key2", childName);
                editor.putString("key3", dob1);
                editor.putString("key4", parentName1);
                editor.commit();
            //store data as persistent
                startActivity(new Intent(login.this, Topics.class));

            }
        });



    }


}
