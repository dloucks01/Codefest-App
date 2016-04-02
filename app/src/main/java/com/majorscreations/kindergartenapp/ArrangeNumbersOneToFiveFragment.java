package com.majorscreations.kindergartenapp;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


public class ArrangeNumbersOneToFiveFragment extends Fragment {

    private ArrayList<Integer> clicked;     // Holds what has been touched, in the order if was touched, to compare to later.
    private ArrayList<Integer> compare;     // The correct order

    private int amountClickedFlag = 0;


    private TextView number1;               // The five numbers that will be clicked.
    private TextView number2;
    private TextView number3;
    private TextView number4;
    private TextView number5;


    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        /**
         * Inflate the layout for this fragment
         */

        View fragmentView = inflater.inflate(
                R.layout.fragment_arrange_numbers_one_to_five, container, false);

        number1 = (TextView) fragmentView.findViewById(R.id.firstNumber);
        number2 = (TextView) fragmentView.findViewById(R.id.secondNumber);
        number3 = (TextView) fragmentView.findViewById(R.id.thirdNumber);
        number4 = (TextView) fragmentView.findViewById(R.id.fourthNumber);
        number5 = (TextView) fragmentView.findViewById(R.id.fifthNumber);

        // Set click listeners
        number1.setOnClickListener(new NumbersClickListener());
        number2.setOnClickListener(new NumbersClickListener());
        number3.setOnClickListener(new NumbersClickListener());
        number4.setOnClickListener(new NumbersClickListener());
        number5.setOnClickListener(new NumbersClickListener());

        clicked = new ArrayList<Integer>();
        compare = new ArrayList<Integer>();
        ArrayList<Integer> scrambled = new ArrayList<Integer>();    // Scrambled arraylist


        // Add numbers to both the correct arraylist, and the arrayList we will scramble
        for (int i = 1; i < 6; i++) {
            compare.add(i);
            scrambled.add(i);
        }

        // Scramble the arraylist
        Collections.shuffle(scrambled);

        // Set the text of the textviews with the scrambled data
        number1.setText(Integer.toString(scrambled.get(0)));
        number2.setText(Integer.toString(scrambled.get(1)));
        number3.setText(Integer.toString(scrambled.get(2)));
        number4.setText(Integer.toString(scrambled.get(3)));
        number5.setText(Integer.toString(scrambled.get(4)));

        return fragmentView;
    }

    private class NumbersClickListener implements View.OnClickListener {

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
                } else {
                    Log.i(getClass().getSimpleName(), "Incorrect");
                }
            }
        }
    }


}
