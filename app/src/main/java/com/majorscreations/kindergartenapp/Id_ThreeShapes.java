package com.majorscreations.kindergartenapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Id_ThreeShapes.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Id_ThreeShapes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Id_ThreeShapes extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Id_ThreeShapes() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Id_ThreeShapes.
     */


    int Number = (int) (5 * Math.random());
    // Right count
    int RMcount;
    // Loss count
    int LMcount;
    //Turns count
    int TMcount;
    Button summitBtn1;
    String attemp = "attempts: "+ LMcount;

    // TODO: Rename and change types and number of parameters
    public static Id_ThreeShapes newInstance(String param1, String param2) {
        Id_ThreeShapes fragment = new Id_ThreeShapes();
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
        final View finalview = inflater.inflate(R.layout.fragment_id__three_shapes, container, false);
        final
        ImageView pic = (ImageView) finalview.findViewById(R.id.picholder);
        final RadioButton circleBtn1 = (RadioButton) finalview.findViewById(R.id.cirRadBtn);
        final RadioButton rectangle1 = (RadioButton) finalview.findViewById(R.id.rectangleRadBtn);
        final RadioButton square1 = (RadioButton) finalview.findViewById(R.id.squareRadBtn);
        final RadioButton pentagon1 = (RadioButton) finalview.findViewById(R.id.pentaRadBtn);
        final RadioButton triangle1 = (RadioButton) finalview.findViewById(R.id.triRadBtn);
        final Button summitBtn1 = (Button) finalview.findViewById(R.id.submitBtn);

        switch (Number) {
            case 0:
                pic.setTag(R.mipmap.circle);
                break;
            case 1:
                pic.setTag(R.mipmap.rectangle);
                break;
            case 2:
                pic.setTag(R.mipmap.square);
                break;
            case 3:
                pic.setTag(R.mipmap.pentagon);
                break;
            case 4:
                pic.setTag(R.mipmap.triangle);
                break;
        }

        summitBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final TextView attemp = (TextView)finalview.findViewById(R.id.triTextView);

                if (circleBtn1.isChecked() && Number == 0) {
                    RMcount++;
                    TMcount++;
                    startActivity(new Intent(getActivity(), OutputActivity.class));
                } else if (circleBtn1.isChecked() && Number != 0) {
                    LMcount++;
                    TMcount++;
                } else if (rectangle1.isChecked() && Number == 1) {
                    RMcount++;
                    TMcount++;
                    startActivity(new Intent(getActivity(), OutputActivity.class));
                } else if (rectangle1.isChecked() && Number != 1) {
                    LMcount++;
                    TMcount++;
                } else if (square1.isChecked() && Number == 2) {
                    RMcount++;
                    TMcount++;
                    startActivity(new Intent(getActivity(), OutputActivity.class));
                } else if (square1.isChecked() && Number != 2) {
                    LMcount++;
                    TMcount++;
                } else if (pentagon1.isChecked() && Number == 3) {
                    RMcount++;
                    TMcount++;
                    startActivity(new Intent(getActivity(), OutputActivity.class));
                } else if (pentagon1.isChecked() && Number != 3) {
                    LMcount++;
                    TMcount++;
                } else if (triangle1.isChecked() && Number == 4) {
                    RMcount++;
                    TMcount++;
                    startActivity(new Intent(getActivity(), OutputActivity.class));
                } else if (triangle1.isChecked() && Number != 4) {
                    LMcount++;
                    TMcount++;
                } else {

                }





            }
        });
        return finalview;

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
