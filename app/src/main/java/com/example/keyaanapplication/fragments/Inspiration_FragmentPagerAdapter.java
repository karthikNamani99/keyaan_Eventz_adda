package com.example.keyaanapplication.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Inspiration_FragmentPagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public Inspiration_FragmentPagerAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount= tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Photos_Fragment tab1 = new Photos_Fragment();
                return tab1;
            case 1:
                RealWedding_Fragment tab2 = new RealWedding_Fragment();
                return tab2;
            case 2:
                Articles_Fragment tab3 = new Articles_Fragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
