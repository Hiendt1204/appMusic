package com.example.hiend.com.example.hiend.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.widget.Switch;

import com.example.hiend.fragment.fr_Albums;
import com.example.hiend.fragment.fr_Artists;
import com.example.hiend.fragment.fr_Songs;

/**
 * Created by Hiend on 9/6/2017.
 */

public class pagerAdapter extends FragmentStatePagerAdapter {
    public pagerAdapter(FragmentManager fragmentManager){
        super(fragmentManager);
    }
    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position){
            case 0:
                frag = new fr_Songs();
                break;
            case 1:
                frag = new fr_Albums();
                break;
            case 2:
                frag = new fr_Artists();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 3;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "SONGS";
                break;
            case 1:
                title = "ALBUMS";
                break;
            case 2:
                title = "ARTISTS";
                break;
        }
        return title;
    }
}
