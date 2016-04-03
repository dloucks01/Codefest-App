package com.majorscreations.kindergartenapp;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class MatchNumberToGroupFragment extends Fragment {

    private ArrayList<Integer> clickedNumber;     // Holds what has been touched, in the order if was touched, to compare to later.
    private ArrayList<Integer> clickedImage;


    private int rightCount = 0;

    final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getActivity());


    private TextView number1;       // The five numbers that will be clicked.
    private TextView number2;
    private TextView number3;
    private TextView number4;
    private TextView number5;


    private ImageButton image1;     // The five images that will be clicked
    private ImageButton image2;
    private ImageButton image3;
    private ImageButton image4;
    private ImageButton image5;


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         */

        View fragmentView = inflater.inflate(
                R.layout.fragment_match_number_to_group, container, false);

        number1 = (TextView) fragmentView.findViewById(R.id.firstNumber);
        number2 = (TextView) fragmentView.findViewById(R.id.secondNumber);
        number3 = (TextView) fragmentView.findViewById(R.id.thirdNumber);
        number4 = (TextView) fragmentView.findViewById(R.id.fourthNumber);
        number5 = (TextView) fragmentView.findViewById(R.id.fifthNumber);


        image1 = (ImageButton)fragmentView.findViewById(R.id.imageButton1);
        image2 = (ImageButton)fragmentView.findViewById(R.id.imageButton2);
        image3 = (ImageButton)fragmentView.findViewById(R.id.imageButton3);
        image4 = (ImageButton)fragmentView.findViewById(R.id.imageButton4);
        image5 = (ImageButton)fragmentView.findViewById(R.id.imageButton5);


        // Set click listeners for numbers
        number1.setOnClickListener(new NumbersClickListener());
        number2.setOnClickListener(new NumbersClickListener());
        number3.setOnClickListener(new NumbersClickListener());
        number4.setOnClickListener(new NumbersClickListener());
        number5.setOnClickListener(new NumbersClickListener());

        // Set click listeners for images
        image1.setOnClickListener(new ImageClickListener());
        image2.setOnClickListener(new ImageClickListener());
        image3.setOnClickListener(new ImageClickListener());
        image4.setOnClickListener(new ImageClickListener());
        image5.setOnClickListener(new ImageClickListener());


        // Set image buttons to integer tags
        image1.setTag(0);
        image2.setTag(1);
        image3.setTag(2);
        image4.setTag(3);
        image5.setTag(4);

        number1.setTag(0);
        number2.setTag(1);
        number3.setTag(2);
        number4.setTag(3);
        number5.setTag(4);




        if (clickedNumber == clickedImage) {          // Checking the arraylist to see if they match. If
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
            //startActivity(new Intent(MathQuestionActivity.this, OutputActivity.class));
        } else {


            Integer wrong = sharedPref.getInt("key6", 0);
            Integer total = sharedPref.getInt("key7", 0);

            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putInt("key6", wrong);
            editor.putInt("key7", total);
            editor.commit();
            Log.i(getClass().getSimpleName(), "Incorrect");
        }


        return fragmentView;
    }

    private class NumbersClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int i;
            TextView tv = (TextView) view;
            tv.setTextColor(getResources().getColor(R.color.dimmed));
            tv.setEnabled(false);


        }
    }

    private class ImageClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            int i;
            ImageButton tv = (ImageButton) view;
            tv.setBackgroundColor(getResources().getColor(R.color.dimmed));
            tv.setEnabled(false);
        }
    }




}
