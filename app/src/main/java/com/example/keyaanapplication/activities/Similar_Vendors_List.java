package com.example.keyaanapplication.activities;

public class Similar_Vendors_List {

    private String resort_name, review_count,location_name,price_plate,rating;
    private int location_image;



    public Similar_Vendors_List(String resort_name,String review_count,String location_name,String price_plate, int location_image, String rating) {
        this.resort_name = resort_name;
        this.review_count = review_count;
        this.location_name = location_name;
        this.price_plate = price_plate;
        this.location_image = location_image;
        this.rating = rating;
    }

    public String getResort_name() {
        return resort_name;
    }

    public void setResort_name(String resort_name) {
        this.resort_name = resort_name;
    }

    public String getReview_count() {
        return review_count;
    }

    public void setReview_count(String review_count) {
        this.review_count = review_count;
    }


    public String getPrice_plate() {
        return price_plate;
    }

    public void setPrice_plate(String price_plate) {
        this.price_plate = price_plate;
    }
    public int getLocation_image() {
        return location_image;
    }

    public void setLocation_image(int location_image) {
        this.location_image = location_image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }
}
