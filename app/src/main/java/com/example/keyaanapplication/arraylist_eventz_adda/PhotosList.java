package com.example.keyaanapplication.arraylist_eventz_adda;

public class PhotosList {

    private int couple_image;
    private String couple_names,couple_weddinglocation,review;
    public PhotosList(String review, String couple_names, String couple_weddinglocation, int couple_image) {
        this.couple_image = couple_image;
        this.couple_names = couple_names;
        this.couple_weddinglocation = couple_weddinglocation;
        this.review = review;

    }


    public String getCoupleName() {
        return couple_names;
    }

    public int getCoupleimage() {
        return couple_image;
    }

    public String getWeddinglocation() {
        return couple_weddinglocation;
    }

    public String getReviews() {
        return review;
    }
}
