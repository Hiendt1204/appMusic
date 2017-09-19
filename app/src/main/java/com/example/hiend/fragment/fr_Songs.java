package com.example.hiend.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hiend.appmusic.MediaManager;
import com.example.hiend.appmusic.R;
import com.example.hiend.appmusic.Songs;
import com.example.hiend.com.example.hiend.adapter.SongAdapter;

import java.util.ArrayList;

/**
 * Created by Hiend on 9/6/2017.
 */

public class fr_Songs extends Fragment {
    private ListView lvList;
    private ArrayList<Songs> mListSong;
    private SongAdapter adapter;
    private MediaManager mediaManager;
    public fr_Songs(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fr_songs_layout,container,false);
    }

}
