package com.example.keyaanapplication.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.keyaanapplication.R;
import com.example.keyaanapplication.onclick_listeners.RecyclerTouchListener;
import com.example.keyaanapplication.onclick_listeners.RecyclerTouchListener1;

import java.util.ArrayList;
import java.util.List;

public class Earnald_Resert extends AppCompatActivity implements View.OnClickListener {


    private List<Similar_Vendors_List> eventList1 = new ArrayList<>();
    private RecyclerView recyclerView;
    private Similar_Vendors_Adapters mAdapter;
    TextView back_btn;
    LinearLayout message_btn, calling_btn, layout_background_gallery, btn_gallery;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earnald_resort);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        btn_gallery = (LinearLayout) findViewById(R.id.btn_gallery);
        message_btn = (LinearLayout) findViewById(R.id.message_btn);
        layout_background_gallery = (LinearLayout) findViewById(R.id.layout_background_gallery);
        calling_btn = (LinearLayout) findViewById(R.id.calling_btn);
        back_btn = (TextView) findViewById(R.id.back_btn);

        back_btn.setOnClickListener(this);
        message_btn.setOnClickListener(this);
        calling_btn.setOnClickListener(this);
        btn_gallery.setOnClickListener(this);
        layout_background_gallery.setOnClickListener(this);

        mAdapter = new Similar_Vendors_Adapters(eventList1, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener1(getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent mIntent;
                switch (position) {
                    case 0: //first item in Recycler view
                        mIntent = new Intent(getApplicationContext(), Earnald_Resert.class);
                        startActivity(mIntent);
                        break;
                    case 1: //second item in Recycler view
                        mIntent = new Intent(getApplicationContext(), Earnald_Resert.class);
                        startActivity(mIntent);
                        break;
                    case 2: //third item in Recycler view
                        mIntent = new Intent(getApplicationContext(), Earnald_Resert.class);
                        startActivity(mIntent);
                        break;
                    case 3: //first item in Recycler view
                        mIntent = new Intent(getApplicationContext(), Earnald_Resert.class);
                        startActivity(mIntent);
                        break;
                    case 4: //second item in Recycler view
                        mIntent = new Intent(getApplicationContext(), Earnald_Resert.class);
                        startActivity(mIntent);
                        break;
                    case 5: //third item in Recycler view
                        mIntent = new Intent(getApplicationContext(), Earnald_Resert.class);
                        startActivity(mIntent);
                        break;


                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        prepareEventsData();
    }

    private void prepareEventsData() {

        Similar_Vendors_List event1 = new Similar_Vendors_List("The Manohar ", "1 Review", "Pune", "On Request", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Similar_Vendors_List("Imperial Garden ", "1 Review", "Pune", "On Request", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Similar_Vendors_List("The Westin Hyderabad", "1 Review", "Pune", "On Request", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Similar_Vendors_List("Park Hyatt", "1 Review", "Pune", "On Request", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Similar_Vendors_List("Alankrita", "1 Review", "Pune", "On Request", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Similar_Vendors_List("Novotel Hyderabad", "1 Review", "Pune", "On Request", R.drawable.img1, "5.0");
        eventList1.add(event1);

        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.btn_gallery:
                Intent gallery_intent = new Intent(getApplicationContext(), Gallery_Images_Activity.class);
                startActivity(gallery_intent);

                break;
            case R.id.layout_background_gallery:
                Intent layout_background_gallery = new Intent(getApplicationContext(), Gallery_Images_Activity.class);
                startActivity(layout_background_gallery);

                break;
            case R.id.message_btn:
                sendSms();

                break;
            case R.id.calling_btn:
                String phone = "04048588655";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
                break;
            case R.id.back_btn:

                Intent back_btn_intent = new Intent(getApplicationContext(), Venues_Activity.class);
                back_btn_intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(back_btn_intent);

                break;
        }
    }

    private void sendSms() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) // At least KitKat
        {
            String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this); // Need to change the build to API 19

            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Eventz Adda");

            if (defaultSmsPackageName != null)// Can be null in case that there is no default, then the user would be able to choose
            // any app that support this intent.
            {
                sendIntent.setPackage(defaultSmsPackageName);
            }
            startActivity(sendIntent);

        } else // For early versions, do what worked for you before.
        {
            Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
            smsIntent.setType("vnd.android-dir/mms-sms");
            smsIntent.putExtra("address", "phoneNumber");
            smsIntent.putExtra("sms_body", "message");
            startActivity(smsIntent);
        }
    }
}
