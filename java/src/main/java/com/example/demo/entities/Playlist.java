package com.example.demo.entities;

import java.util.*;

public class Playlist {
    // Unique identifier for this playlist
    private Long id;
    // List of songs in the playlist
    private final LinkedList<Songs> songList;
    // Name of the playlist
    private final String playlistName;

    public Playlist(String playlistName,LinkedList<Songs> songList){
        this.playlistName = playlistName;
        this.songList = songList;
        // ID is set by the database when saved
        this.id = null;
    }

    public void setId(Long autoIncrement) {
        this.id = autoIncrement;
    }

    public String getName(){
        return playlistName;
    }

    public LinkedList<Songs> getPlaylist(){
        return songList;
    }
    
    @Override
    public String toString() {
        return "Playlist [id=" + id + "]";
    }

    public Object getId() {
        return id;
    }
}
