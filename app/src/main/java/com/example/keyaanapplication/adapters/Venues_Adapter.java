package com.example.keyaanapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keyaanapplication.R;
import com.example.keyaanapplication.arraylist_eventz_adda.Venues_list;

import java.util.List;

public class Venues_Adapter extends RecyclerView.Adapter<Venues_Adapter.MyViewHolder> {
    private List<Venues_list> eventList1 ;
    private Context context;

    public Venues_Adapter(List<Venues_list> events, Context mContext) {
        this.eventList1 = events;
        this.context = mContext;


    }


//    public void filterList(List<Venues_list> filterdNames) {
//        this.eventList1 = filterdNames;
//        notifyDataSetChanged();
//    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView resort_name, review_count, location_name, price_plate, rating;
        public ImageView location_image;

        public MyViewHolder(View view) {
            super(view);
            resort_name = (TextView) view.findViewById(R.id.textViewName);
            location_image = (ImageView) view.findViewById(R.id.imageView);
            review_count = (TextView) view.findViewById(R.id.textViewresult);
            location_name = (TextView) view.findViewById(R.id.location_name);
            price_plate = (TextView) view.findViewById(R.id.price_rate);
            rating = (TextView) view.findViewById(R.id.rating_number);
        }
    }


    @Override
    public Venues_Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.venues_listitems_main, parent, false);

        MyViewHolder myViewHolder = new MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(Venues_Adapter.MyViewHolder holder, int position) {
        Venues_list event = eventList1.get(position);
        holder.resort_name.setText(event.getResort_name());
        holder.location_image.setImageResource(event.getLocation_image());
        holder.review_count.setText(event.getReview_count());
        holder.location_name.setText(event.getLocation_name());
        holder.price_plate.setText(event.getPrice_plate());
        holder.rating.setText(event.getRating());
    }

    @Override
    public int getItemCount() {
        return eventList1.size();
    }




}
