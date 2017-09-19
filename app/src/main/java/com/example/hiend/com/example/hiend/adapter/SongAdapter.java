package com.example.hiend.com.example.hiend.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hiend.appmusic.R;
import com.example.hiend.appmusic.Songs;

import java.util.ArrayList;

/**
 * Created by Hiend on 9/18/2017.
 */

public class SongAdapter extends BaseAdapter {
    private ArrayList<Songs> mListSong;
    private LayoutInflater inflater;

    public SongAdapter(Context context, ArrayList<Songs> mListSong) {
        this.mListSong = mListSong;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mListSong.size();
    }

    @Override
    public Songs getItem(int position) {
        return mListSong.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    private static class ViewHolder{
        TextView tv_Song;
        TextView tv_Artists;
        TextView tv_Time;
        ImageView imv_previous;
        ImageView imv_next;
        ImageView imv_shuffle;
        ImageView imv_repeat;
        ImageView imv_play;

    }

    @Override
    public View getView(int postion, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder=new ViewHolder();
            convertView=inflater.inflate(R.layout.item,parent,false);
            viewHolder.tv_Song=(TextView) convertView.findViewById(R.id.tv_Song);
            viewHolder.tv_Artists=(TextView) convertView.findViewById(R.id.tv_Artists);

            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder) convertView.getTag();
        }
        Songs songs=mListSong.get(postion);
        viewHolder.tv_Song.setText(songs.getName());
        viewHolder.tv_Artists.setText(songs.getArtist());
        return convertView;


    }

}
