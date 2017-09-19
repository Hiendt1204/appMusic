package com.example.hiend.appmusic;

/**
 * Created by Hiend on 9/13/2017.
 */

public class Songs {
    private int id;
    private String name;
    private String album;
    private String artist;
    private String path;
    private int duration;

    public Songs(int id, String name, String album, String artist, String path, int duration) {
        this.id=id;
        this.name = name;
        this.album = album;
        this.artist = artist;
        this.path = path;
        this.duration = duration;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getPath() {

        return path;
    }

    public void setPath(String path) {

        this.path = path;
    }

    public String getAlbum() {

        return album;
    }

    public void setAlbum(String album) {

        this.album = album;
    }

    public String getArtist() {

        return artist;
    }

    public void setArtist(String artist) {

        this.artist = artist;
    }

    public int getDuration() {

        return duration;
    }

    public void setDuration(int duration) {

        this.duration = duration;
    }

    public Songs() {
    }
}
