package com.majorscreations.kindergartenapp;

import android.app.Fragment;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class MatchNumberToGroupFragment extends Fragment {

    private ArrayList<Integer> clickedNumber;     // Holds what has been touched, in the order if was touched, to compare to later.
    private ArrayList<Integer> clickedImage;

    final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());
    int firstEntry, secondEntry, thirdEntry, fourthEntry, fifthEntry, counter;


    private EditText number1;       // The five numbers that will be clicked.
    private EditText number2;
    private EditText number3;
    private EditText number4;
    private EditText number5;



    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         */

        final View fragmentView = inflater.inflate(
                R.layout.fragment_match_number_to_group, container, false);
        number1 = (EditText)fragmentView.findViewById(R.id.inputOne);
        number2 = (EditText)fragmentView.findViewById(R.id.inputTwo);
        number3 = (EditText)fragmentView.findViewById(R.id.inputThree);
        number4 = (EditText)fragmentView.findViewById(R.id.inputFour);
        number5 = (EditText)fragmentView.findViewById(R.id.inputFive);

        firstEntry = Integer.parseInt(number1.getText().toString());
        if(firstEntry == 4 && secondEntry == 1 && thirdEntry == 3 && fourthEntry == 2 && fifthEntry == 5)
        {
            Log.i(getClass().getSimpleName(), "Correct");


            Integer right = sharedPref.getInt("key5", 0);
            Integer total = sharedPref.getInt("key7", 0);

            right += 1;
            total += 1;

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("key5", right);
            editor.putInt("key7", total);
            editor.commit();
        }

        else {
            Integer wrong = sharedPref.getInt("key6", 0);
            Integer total = sharedPref.getInt("key7", 0);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("key6", wrong);
            editor.putInt("key7", total);
            editor.commit();
            Log.i(getClass().getSimpleName(), "Incorrect");


        }

        final Button completeButton = (Button)fragmentView.findViewById(R.id.completeButton);
        completeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        return fragmentView;

<<<<<<< HEAD
        @Override
        public void onClick(View view) {
            TextView tv = (TextView) view;
            int value = Integer.parseInt(tv.getText().toString());
            tv.setTextColor(getResources().getColor(R.color.dimmed));
            clicked.add(value);
            amountClickedFlag += 1;

            if (amountClickedFlag == 5) {
                if (compare.equals(clicked)) {          // Checking the arraylist to see if they match. If
                    // They do, then we have a correct result
                    Log.i(getClass().getSimpleName(), "Correct");


                    Integer right = sharedPref.getInt("key5", 0);
                    Integer total = sharedPref.getInt("key7", 0);

                    right += 1;
                    total += 1;

                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("key5", right);
                    editor.putInt("key7", total);
                    editor.commit();
                    Intent i = new Intent(getActivity(), OutputActivity.class);
                    startActivity(i);
                } else {
=======
    }
>>>>>>> f301320b606365a5c318262e6ce4cfc5a4b5de52



<<<<<<< HEAD
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putInt("key6", wrong);
                    editor.putInt("key7", total);
                    editor.commit();
                    Intent i = new Intent(getActivity(), OutputActivity.class);
                    startActivity(i);
                    Log.i(getClass().getSimpleName(), "Incorrect");
                }
            }
        }
    }
=======
>>>>>>> f301320b606365a5c318262e6ce4cfc5a4b5de52


}
