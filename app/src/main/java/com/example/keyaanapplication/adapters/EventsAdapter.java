package com.example.keyaanapplication.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keyaanapplication.arraylist_eventz_adda.EventList;
import com.example.keyaanapplication.R;

import java.util.List;

public class EventsAdapter extends RecyclerView.Adapter<EventsAdapter.MyViewHolder> {

    private List<EventList> eventList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView designation_name, result;
        public  ImageView event_icon,item_back;
        public MyViewHolder(View view) {
            super(view);
            designation_name = (TextView) view.findViewById(R.id.textViewName);
            event_icon = (ImageView) view.findViewById(R.id.imageView);
            result = (TextView) view.findViewById(R.id.textViewresult);
            item_back = (ImageView) view.findViewById(R.id.itemback);

        }
    }


    public EventsAdapter(List<EventList> eventList) {
        this.eventList = eventList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vendors_item_main, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        EventList event = eventList.get(position);
        holder.designation_name.setText(event.getDesignation_name());
        holder.event_icon.setImageResource(event.getEvent_icon());
        holder.item_back.setImageResource(event.getItem_backimage());
        holder.result.setText(event.getResult());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

}
