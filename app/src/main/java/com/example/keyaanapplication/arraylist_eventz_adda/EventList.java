package com.example.keyaanapplication.arraylist_eventz_adda;

import android.graphics.drawable.Drawable;

public class EventList {
    private String designation_name, result;
    private int event_icon, item_back;


    public EventList(String designation_name, int event_icon, String result, int item_back) {
        this.designation_name = designation_name;
        this.event_icon = event_icon;
        this.item_back = item_back;
        this.result = result;
    }

    public String getDesignation_name() {
        return designation_name;
    }

    public void setDesignation_name(String name) {
        this.designation_name = name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getEvent_icon() {
        return event_icon;
    }

    public void setEvent_icon(int event_icon) {
        this.event_icon = event_icon;
    }

    public int getItem_backimage() {
        return item_back;
    }

    public void setItem_back(int item_back) {
        this.item_back = item_back;
    }
}
