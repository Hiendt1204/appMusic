package com.example.hiend.appmusic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hiend on 9/15/2017.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Song_list";
    public static final String TABLE_NAME = "song";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ALBUM = "album";
    public static final String ARTISTS = "artists";
    public static final String DURATION = "duration";

    private Context context;
    public MyDatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        Log.d("MyDatabaseHelper", "MyDatabaseHelper: ");
        this.context=context;

    }


    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MyDatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlQuery=" CREATE TABLE "+TABLE_NAME +" ("+
                ID +" integer primary key, "+
                NAME + " TEXT, "+
                ALBUM + " TEXT, "+
                ARTISTS + " TEXT, "+
                DURATION +" TEXT)";
        sqLiteDatabase.execSQL(sqlQuery);
        Toast.makeText(context, "Create successfylly", Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
        Toast.makeText(context, "Drop successfylly", Toast.LENGTH_SHORT).show();
    }
    public void addSong(Songs song){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME, song.getName());
        values.put(ALBUM, song.getAlbum());
        values.put(ARTISTS, song.getArtist());
        values.put(DURATION, song.getDuration());
        //Neu de null thi khi value bang null thi loi

        db.insert(TABLE_NAME,null,values);

        db.close();
    }
    public Songs getSongById(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[] { ID,
                        NAME, ALBUM,ARTISTS,DURATION }, ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Songs song = new Songs(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getInt(5));
        cursor.close();
        db.close();
        return song;
    }
    public List<Songs> getAllSong() {
        List<Songs> listSong = new ArrayList<Songs>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Songs song = new Songs();
                song.setId(cursor.getInt(0));
                song.setName(cursor.getString(1));
                song.setAlbum(cursor.getString(2));
                song.setArtist(cursor.getString(3));
                song.setDuration(cursor.getInt(4));
                listSong.add(song);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listSong;
    }
    public int Update(Songs song){
        SQLiteDatabase db= this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,song.getName());
        return db.update(TABLE_NAME,values,ID+"=?",new String[]{String.valueOf(song.getId())});
    }
    public void deleteSong(Songs song){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(song.getId())});
        db.close();
    }
    public int getSongCount(){
        String countQuery="SELECT  * FROM "+TABLE_NAME;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        return cursor.getCount();
    }

}
