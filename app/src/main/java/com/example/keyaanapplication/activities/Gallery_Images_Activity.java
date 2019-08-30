package com.example.keyaanapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.keyaanapplication.R;
import com.example.keyaanapplication.adapters.Gallery_Adapter1;
import com.example.keyaanapplication.arraylist_eventz_adda.Catering_List;
import com.example.keyaanapplication.arraylist_eventz_adda.ListImages;

import java.util.ArrayList;
import java.util.List;

public class Gallery_Images_Activity extends AppCompatActivity implements View.OnClickListener {

    TextView back_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("GridView");
        setContentView(R.layout.gallery_images);

        // Set the images from ImageAdapter.java to GridView
        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new Gallery_Adapter1(this));

        back_btn = (TextView) findViewById(R.id.back_btn);

        back_btn.setOnClickListener(this);

        // Listening to GridView item click
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), Images_Activity.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {


            case R.id.back_btn:
                Intent back_btn_intent = new Intent(getApplicationContext(), Earnald_Resert.class);
                back_btn_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(back_btn_intent);
                break;

        }
    }
}
