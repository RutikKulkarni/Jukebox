package com.example.demo.services;

import java.util.*;
import com.example.demo.entities.Songs;
import com.example.demo.repositories.ISongRepo;

public class SongService {
    private final ISongRepo iSongRepo;

    // Constructor to inject the Song Repository dependency
    public SongService(ISongRepo iSongRepo) {
        this.iSongRepo = iSongRepo;
    }

    // Method to add a new song and save it in the repository
    public Songs addSong(String songName,String artist,String album,String genre){
        Songs s = new Songs(songName, artist, album, genre);
        iSongRepo.save(s);
        return s;
    }

    // Method to retrieve a list of all songs from the repository
    public List<String> getAllSongs(){
        return iSongRepo.findall();
    }

    // Method to find a song by its ID in the repository
    public Songs findbyId(Long id) {
        return iSongRepo.findbyId(id);
    }
}
