package com.majorscreations.kindergartenapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class OutputActivity extends AppCompatActivity {

    private ListView categoryListView;
    private ArrayAdapter<String> categoryArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_output);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button sendResults = (Button)findViewById(R.id.results);
        setSupportActionBar(toolbar);
        toolbar.setTitle("OutputInformation");

        String[] categories = getResources().getStringArray(R.array.categories);

        // Create the listview for the categories, and set the ArrayAdapter for the listview
        categoryListView = (ListView) findViewById(R.id.headingCategoryListView);
        categoryArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, categories);
        categoryListView.setAdapter(categoryArrayAdapter);


        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        final String parent_Name = sharedPref.getString("key4", "Nope");
        final String child_Name = sharedPref.getString("key2", "Nope");
        final String Date_of_Birth = sharedPref.getString("key3","Nope");

        TextView pName = (TextView)findViewById(R.id.parentNameTextView);
        TextView cName = (TextView)findViewById(R.id.childsNameTextView);
        TextView dobName = (TextView)findViewById(R.id.editTextdob);

        pName.setText(parent_Name);
        cName.setText(child_Name + "'s Results");



        sendResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sendEmail = new Intent(Intent.ACTION_SEND);
                sendEmail.putExtra(Intent.EXTRA_EMAIL, new String[]{parent_Name});
                sendEmail.putExtra(Intent.EXTRA_SUBJECT, "Kindergarten Readiness Results");
                sendEmail.putExtra(Intent.EXTRA_TEXT, "Output Results");
                sendEmail.setType("message/text");
                startActivity(Intent.createChooser(sendEmail,"Choose an Email Client :"));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_output, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
