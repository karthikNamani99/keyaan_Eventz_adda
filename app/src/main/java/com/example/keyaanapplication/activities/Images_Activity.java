package com.example.keyaanapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.keyaanapplication.R;
import com.example.keyaanapplication.adapters.Gallery_Adapter1;
import com.example.keyaanapplication.adapters.ViewPager_Adapter;
import com.example.keyaanapplication.arraylist_eventz_adda.ListImages;
import com.example.keyaanapplication.fragments.Image_Fragment;

import java.util.ArrayList;
import java.util.List;

public class Images_Activity extends AppCompatActivity {

    // Declare Variable
    int position;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set title for the ViewPager
        setTitle("ViewPager");
        // Get the view from view_pager.xml
        setContentView(R.layout.images_main);

        // Loop through the ids to create a list of full screen image views
        Gallery_Adapter1 imageAdapter1 = new Gallery_Adapter1(this);
        List<ImageView> images = new ArrayList<ImageView>();

        for (int i = 0; i < imageAdapter1.getCount(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageAdapter1.mThumbIds[i]);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            images.add(imageView);
        }

        // Finally create the adapter
        ViewPager_Adapter imagePagerAdapter = new ViewPager_Adapter(images);
        ViewPager viewPager = (ViewPager) findViewById(R.id.fullimage);
        viewPager.setAdapter(imagePagerAdapter);

        // Set the ViewPager to point to the selected image from the previous activity
        // Selected image id
        int position = getIntent().getExtras().getInt("id");
        viewPager.setCurrentItem(position);
    }
    }

