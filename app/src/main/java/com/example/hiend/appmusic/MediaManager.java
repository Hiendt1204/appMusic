package com.example.hiend.appmusic;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

/**
 * Created by Hiend on 9/13/2017.
 */

public class MediaManager {
    private MediaPlayer mPlayer;
    private Context mContext;
    private ArrayList<Songs> mListSong;

    public MediaManager(Context context) {
        mContext = context;
        initData();
    }

    public ArrayList<Songs> getmListSong() {
        return mListSong;
    }

    private void initData() {
        mPlayer = new MediaPlayer();
        mListSong = new ArrayList<>();

        Uri audioUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

        String projecttion[] = new String[]{
                MediaStore.Audio.AlbumColumns.ALBUM_ID,
                MediaStore.Audio.AudioColumns.TITLE,
                MediaStore.Audio.AudioColumns.DATA,
                MediaStore.Audio.AudioColumns.ALBUM,
                MediaStore.Audio.AudioColumns.ARTIST,
                MediaStore.Audio.AudioColumns.DURATION

        };
        String where = MediaStore.Audio.AudioColumns.DISPLAY_NAME + " LIKE '%.mp3'";

        Cursor c = mContext.getContentResolver().query(audioUri, projecttion, where, null, null);

        if (c == null) {
            return;
        }
        c.moveToFirst();
        int indexId = c.getColumnIndex(projecttion[0]);
        int indexTitle = c.getColumnIndex(projecttion[1]);
        int indexData = c.getColumnIndex(projecttion[2]);
        int indexAlbum = c.getColumnIndex(projecttion[3]);
        int indexArtist = c.getColumnIndex(projecttion[4]);
        int indexDuration = c.getColumnIndex(projecttion[5]);

        String name, path, album, artist;
        int duration, id;

        while (!c.isAfterLast()) {
            id = c.getInt(indexId);
            name = c.getString(indexTitle);
            path = c.getString(indexData);
            album = c.getString(indexAlbum);
            artist = c.getString(indexArtist);
            duration = c.getInt(indexDuration);

            mListSong.add(new Songs(id, name, path, album, artist, duration));

            c.moveToNext();

        }
        c.close();


    }
}
