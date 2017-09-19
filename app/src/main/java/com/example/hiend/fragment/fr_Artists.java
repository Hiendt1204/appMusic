package com.example.hiend.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hiend.appmusic.R;

/**
 * Created by Hiend on 9/6/2017.
 */

public class fr_Artists extends Fragment {
    public fr_Artists(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fr_artists_layout,container,false);
    }

}
