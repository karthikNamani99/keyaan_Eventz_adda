package com.example.keyaanapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.keyaanapplication.R;
import com.example.keyaanapplication.adapters.Decoration_Adapter;

import com.example.keyaanapplication.arraylist_eventz_adda.Decoration_List;

import com.example.keyaanapplication.arraylist_eventz_adda.Venues_list;
import com.example.keyaanapplication.onclick_listeners.RecyclerTouchListener;
import com.example.keyaanapplication.onclick_listeners.RecyclerTouchListener1;

import java.util.ArrayList;
import java.util.List;

public class Decorations_Activity extends AppCompatActivity implements View.OnClickListener {
    private List<Decoration_List> eventList1 = new ArrayList<>();
    private RecyclerView recyclerView;
    private Decoration_Adapter mAdapter;
    EditText editTextSearch;

    private RadioGroup radioGroup;
    private RadioButton sound, vibration, silent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.decorations_main);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new Decoration_Adapter(eventList1,this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        editTextSearch = (EditText) findViewById(R.id.editTextSearch);
        TextView back_btn=(TextView)findViewById(R.id.back_btn);
        back_btn.setOnClickListener(this);
        editTextSearch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence query, int start, int before, int count) {

                query = query.toString().toLowerCase();

                final List<Decoration_List> filteredList = new ArrayList<>();

                for (int i = 0; i < eventList1.size(); i++) {

                    final String text = eventList1.get(i).getResort_name().toLowerCase();
                    if (text.contains(query)) {

                        filteredList.add(eventList1.get(i));
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(Decorations_Activity.this));
                mAdapter = new Decoration_Adapter(filteredList, Decorations_Activity.this);
                recyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();  // data set changed
                // data set changed
            }
        });

//        radioGroup = (RadioGroup) findViewById(R.id.myRadioGroup);
//
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                // find which radio button is selected
//                if(checkedId == R.id.eventlocation_details) {
//                    Intent intent=new Intent(getApplicationContext(),Venues_Activity.class);
//                    startActivity(intent);
//                    finish();
//                } else if(checkedId == R.id.event_location) {
//                    Intent intent=new Intent(getApplicationContext(),Decorations_Activity.class);
//                    startActivity(intent);
//                    finish();
//                }
//            }
//
//        });
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
                    case 5: //second item in Recycler view
                        mIntent = new Intent(getApplicationContext(), Earnald_Resert.class);
                        startActivity(mIntent);
                        break;
                    case 6: //third item in Recycler view
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

        Decoration_List event1 = new Decoration_List("Courtyard by Marriott Pune City ...", "1 Review", "Pune", "1000 per plate", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Decoration_List("Courtyard by Marriott Pune City ...", "1 Review", "Pune", "1000 per plate", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Decoration_List("Courtyard by Marriott Pune City ...", "1 Review", "Pune", "1000 per plate", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Decoration_List("Courtyard by Marriott Pune City ...", "1 Review", "Pune", "1000 per plate", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Decoration_List("Courtyard by Marriott Pune City ...", "1 Review", "Pune", "1000 per plate", R.drawable.img1, "5.0");
        eventList1.add(event1);

        event1 = new Decoration_List("Courtyard by Marriott Pune City ...", "1 Review", "Pune", "1000 per plate", R.drawable.img1, "5.0");
        eventList1.add(event1);




        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.back_btn:

                Intent intent=new Intent(getApplicationContext(),Navigation_drawer.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
//                doExit();

                break;
        }
    }
}
