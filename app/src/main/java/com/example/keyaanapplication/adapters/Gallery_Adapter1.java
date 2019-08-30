package com.example.keyaanapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.keyaanapplication.R;
import com.example.keyaanapplication.activities.Gallery_Images_Activity;
import com.example.keyaanapplication.arraylist_eventz_adda.ListImages;


import java.util.List;

public class Gallery_Adapter1 extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.venues1, R.drawable.decorations,
            R.drawable.catering, R.drawable.entertainment,
            R.drawable.entertainment1, R.drawable.videography,
            R.drawable.photography, R.drawable.venues,
            R.drawable.decorations, R.drawable.catering,
            R.drawable.entertainment1,R.drawable.photography,
            R.drawable.venues, R.drawable.decorations,
            R.drawable.catering, R.drawable.entertainment1


    };

    // Constructor
    public Gallery_Adapter1(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new GridView.LayoutParams(350, 350
        ));
        return imageView;
    }
}
