package com.example.keyaanapplication.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.keyaanapplication.R;
import com.example.keyaanapplication.adapters.Cattering_Adapter;
import com.example.keyaanapplication.arraylist_eventz_adda.Catering_List;

import java.util.List;

public class Similar_Vendors_Adapters extends RecyclerView.Adapter<Similar_Vendors_Adapters.MyViewHolder> {
    private List<Similar_Vendors_List> eventList1 ;
    private Context context;

    public Similar_Vendors_Adapters(List<Similar_Vendors_List> events, Context mContext) {
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
    public Similar_Vendors_Adapters.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.similar_vendor_items, parent, false);

        Similar_Vendors_Adapters.MyViewHolder myViewHolder = new Similar_Vendors_Adapters.MyViewHolder(itemView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(Similar_Vendors_Adapters.MyViewHolder holder, int position) {
        Similar_Vendors_List event = eventList1.get(position);
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
