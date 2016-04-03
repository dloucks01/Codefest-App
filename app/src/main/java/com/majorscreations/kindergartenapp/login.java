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
import android.widget.Toast;

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

                String error = "null";
                // Check to see if any of the fields are empty
                // Concatenate the fields needed to be checked by the user
                if (isEmpty(name)) {
                    error += "Child's name\n";
                }
                if (isEmpty(email)){
                    error += "Parents E-mail address\n";
                }
                if (isEmpty(dob)) {
                    error += "Child Date of Birth\n";
                }
                if (isEmpty(parentsName)) {
                    error += "Parents name\n";
                }

                if (error.equals("null") ) {  // No error

                    email1 = (email.getText().toString());
                    childName = (name.getText().toString());
                    dob1 = (dob.getText().toString());
                    parentName1 = (parentsName.getText().toString());
                } else {

                    error = error.substring(4);

                    Toast.makeText(getApplicationContext(), "Please fill in the following fields:\n\n" + error, Toast.LENGTH_LONG).show();
                    return;

                }



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

    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }




}
