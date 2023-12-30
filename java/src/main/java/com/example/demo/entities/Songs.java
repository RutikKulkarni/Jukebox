package com.example.demo.entities;

import com.example.demo.repositories.ISongRepo;

public class Songs {
    private final String songName;
    private final String artist;
    private final String album;
    private final String genre;
    private Long id;
    
    ISongRepo sRepo;
    // Constructor
    public Songs(String songName,String artist,String album,String genre){
        this.songName = songName;
        this.artist = artist;
        this.album = album;
        this.genre = genre;
        this.id = null;
    }

    // Getter for song name
    public String getSongName() {
        return this.songName;
    }

    // Getter for song ID
    public Long getID() {
        return id;
    }

    // Find song by ID
    public Songs getSongbyID(Long id) {
        return sRepo.findbyId(id);
    }

    // Setter for song ID
    public void setId(Long ID){
        this.id = ID;
    }

    @Override
    public String toString() {
        return "Song [id=" + id + "]";
    }
}