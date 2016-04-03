package com.majorscreations.kindergartenapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link underStandMoreOrLessFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link underStandMoreOrLessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class underStandMoreOrLessFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public underStandMoreOrLessFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment underStandMoreOrLessFragment.
     */

     private TextView yourNum, lessNum;
     private int greaterNum2, lesserNum2;
    // Right count
     int RMcount;
    // Loss count
     int LMcount;
    //Turns count
     int TMcount;


    // TODO: Rename and change types and number of parameters
    public static underStandMoreOrLessFragment newInstance(String param1, String param2) {
        underStandMoreOrLessFragment fragment = new underStandMoreOrLessFragment();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_under_stand_more_or_less, container, false);

        yourNum = (TextView)fragmentView.findViewById(R.id.randomNumMore);
        lessNum = (TextView)fragmentView.findViewById(R.id.textViewRandNumLess);
        Button  greaterBtn1 = (Button)fragmentView.findViewById(R.id.greaterBtn);
        Button  lesserBtn1 = (Button)fragmentView.findViewById(R.id.lesserBtn);



        int higherNumber = (int) (5 * Math.random() + 1);
        final int lowerNumber = (int) (5 * Math.random() + 1);

        yourNum.setText(Integer.toString(higherNumber));
        lessNum.setText(Integer.toString(lowerNumber));

        greaterNum2 = Integer.parseInt(yourNum.getText().toString());
        lesserNum2 = Integer.parseInt(lessNum.getText().toString());

        greaterBtn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(greaterNum2 >= lesserNum2)
                {
                    RMcount++;
                    TMcount++;
                    startActivity(new Intent(getActivity(), OutputActivity.class));
                }
                else if (greaterNum2 < lesserNum2)
                {
                    LMcount++;
                    TMcount++;
                }
            }
        });

        lesserBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (greaterNum2 <= lesserNum2){
                    RMcount++;
                    TMcount++;
                    startActivity(new Intent(getActivity(), MathQuestionActivity.class));
                }
                else if (lesserNum2 >= lesserNum2){
                    LMcount++;
                    TMcount++;
                }
            }
        });

        return fragmentView;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
