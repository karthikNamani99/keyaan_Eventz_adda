package com.example.keyaanapplication.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.keyaanapplication.R;
import com.example.keyaanapplication.activities.Catering_Activity;
import com.example.keyaanapplication.activities.Decorations_Activity;
import com.example.keyaanapplication.activities.Entertainment_Activity;
import com.example.keyaanapplication.activities.Photography_Activity;
import com.example.keyaanapplication.activities.Videography_Activity;
import com.example.keyaanapplication.onclick_listeners.RecyclerTouchListener;
import com.example.keyaanapplication.activities.Venues_Activity;
import com.example.keyaanapplication.adapters.EventsAdapter;
import com.example.keyaanapplication.arraylist_eventz_adda.EventList;

import java.util.ArrayList;
import java.util.List;

public class VendorsFragment extends Fragment {

    private List<EventList> eventList = new ArrayList<>();
    private RecyclerView recyclerView;
    private EventsAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vendors_fragment, container, false);



        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);

        mAdapter = new EventsAdapter(eventList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);




        // row click listener
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent mIntent;
                switch (position) {
                    case 0: //first item in Recycler view
                        mIntent = new Intent (getActivity(), Venues_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 1: //second item in Recycler view
                        mIntent = new Intent (getActivity(), Decorations_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 2: //third item in Recycler view
                        mIntent = new Intent (getActivity(), Videography_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 3: //first item in Recycler view
                        mIntent = new Intent (getActivity(), Photography_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 4: //second item in Recycler view
                        mIntent = new Intent (getActivity(), Catering_Activity.class);
                        startActivity(mIntent);
                        break;
                    case 5: //third item in Recycler view
                        mIntent = new Intent (getActivity(), Entertainment_Activity.class);
                        startActivity(mIntent);
                        break;

                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
        prepareEventsData();
        return view;
    }

    private void prepareEventsData() {
        EventList event = new EventList("Venues", R.drawable.venues_logo, "256 results", R.drawable.venues1);
        eventList.add(event);

        event = new EventList("Decorations", R.drawable.decoration_icon, "156 results", R.drawable.decorations);
        eventList.add(event);

        event = new EventList("VideoGraphy", R.drawable.videographers_logo, "115 results", R.drawable.videography);
        eventList.add(event);

        event = new EventList("PhotoGraphy", R.drawable.photographers_logo, "215 results", R.drawable.photography);
        eventList.add(event);

        event = new EventList("Cattering", R.drawable.catering_logo, "25 results", R.drawable.catering);
        eventList.add(event);

        event = new EventList("Entertainment", R.drawable.entertainment_logo, "185 results", R.drawable.entertainment);
        eventList.add(event);



        mAdapter.notifyDataSetChanged();
    }

}
