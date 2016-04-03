package com.majorscreations.kindergartenapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Topics extends AppCompatActivity {

    Integer[] Choices = {R.mipmap.math};
    ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);
        GridView grid = (GridView)findViewById(R.id.gridView);

        grid.setAdapter(new ImageAdapter(this));
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                //switch based on location to open each activity.
                switch (position) {
                    case 0:
                        //Call Mathematics, right now call output
                        startActivity(new Intent(Topics.this, MathQuestionActivity.class));
                        break;
                }
            }
        });


    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;

        public ImageAdapter(Context c){
            context = c;
        }

        @Override
        public int getCount() {
            return Choices.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            pic = new ImageView(context);
            pic.setImageResource(Choices[position]);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
            pic.setLayoutParams(new GridView.LayoutParams(330,300));
            return pic;
        }
    }

}

