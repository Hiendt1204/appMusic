package com.example.hiend.appmusic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hiend.com.example.hiend.adapter.SongAdapter;

import java.util.ArrayList;

/**
 * Created by Hiend on 9/8/2017.
 */

public class PlayActivity extends AppCompatActivity implements View.OnClickListener {
    private ListView lvList;
    private ArrayList<Songs> mListSong;
    private ImageView imv_Background, imv_previous, imv_next, imv_shuffle, imv_repeat, imv_play;
    private TextView tv_Song, tv_Artists, tv_Time;
    private SongAdapter adapter;
    private MediaManager mediaManager;

    private static final int LEVEL_PLAY = 0;
    private static final int LEVEL_PAUSE = 1;
    private int levelPlay = LEVEL_PLAY;
    private static final int LEVEL_OFF = 0;
    private static final int LEVEL_ON = 1;

    private static final int LEVEL_REPEAT_OFF = 0;
    private static final int LEVEL_REPEAT_ONE = 1;
    private static final int LEVEL_REPEAT_ON = 2;
    private int levelRepeat = LEVEL_REPEAT_OFF;

    private static final int LEVEL_SHUFFLE_OFF = 0;
    private static final int LEVEL_SHUFFLE_ON = 1;
    private int levelShuffle = LEVEL_OFF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_song);
        initData();
        initView();
    }

    private void initData() {
        mediaManager = new MediaManager(this);
        mListSong = mediaManager.getmListSong();
        adapter = new SongAdapter(this, mListSong);
    }

    private void initView() {
        lvList = (ListView) findViewById(R.id.lv_Songs);
        lvList.setAdapter(adapter);
        tv_Artists = (TextView) findViewById(R.id.tv_Artists);
        tv_Song = (TextView) findViewById(R.id.tv_Song);
        tv_Time = (TextView) findViewById(R.id.tv_Time);

        imv_Background = (ImageView) findViewById(R.id.imv_Background);
        imv_repeat = (ImageView) findViewById(R.id.imv_repeat);
        imv_next = (ImageView) findViewById(R.id.imv_next);
        imv_previous = (ImageView) findViewById(R.id.imv_previous);
        imv_shuffle = (ImageView) findViewById(R.id.imv_shuffle);
        imv_play = (ImageView) findViewById(R.id.imv_play);

        imv_play.setOnClickListener(this);
        imv_shuffle.setOnClickListener( this);
        imv_previous.setOnClickListener(this);
        imv_next.setOnClickListener(this);
        imv_repeat.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imv_repeat:
                doRepeat();
                break;
            case R.id.imv_next:
                doNext();
                break;
            case R.id.imv_play:
                doPlay();
                break;
            case R.id.imv_previous:
                doPrevious();
                break;
            case R.id.imv_shuffle:
                doShuffle();
                break;
            default:
                break;
        }

    }

    private void doShuffle() {
        if (levelShuffle == LEVEL_ON) {
            imv_shuffle.setImageLevel(LEVEL_OFF);
            levelShuffle = LEVEL_OFF;
        } else {
            imv_shuffle.setImageLevel(LEVEL_ON);
            levelShuffle = LEVEL_ON;
        }

    }

    private void doPrevious() {
    }

    private void doNext() {
    }

    private void doRepeat() {
        if (levelRepeat == LEVEL_REPEAT_OFF) {
            levelRepeat = LEVEL_REPEAT_ONE;
            imv_repeat.setImageLevel(LEVEL_REPEAT_ONE);
        } else if (levelRepeat == LEVEL_REPEAT_ONE) {
            levelRepeat = LEVEL_REPEAT_ON;
            imv_repeat.setImageLevel(LEVEL_REPEAT_ON);
        } else {
            levelRepeat = LEVEL_REPEAT_OFF;
            imv_repeat.setImageLevel(LEVEL_REPEAT_OFF);
        }

    }

    private void doPlay() {
        if (levelPlay == LEVEL_PLAY) {
            imv_play.setImageLevel(LEVEL_PAUSE);
            levelPlay = LEVEL_PAUSE;
        } else {
            imv_play.setImageLevel(LEVEL_PLAY);
            levelPlay = LEVEL_PLAY;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
