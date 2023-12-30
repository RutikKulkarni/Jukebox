package com.example.demo.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import com.example.demo.entities.Playlist;


public class PlaylistRepository implements IPlaylistRepository{
    // A variable to keep track of the auto-incremented ID for playlists
    private Long autoIncrement = 1L;
    // A map to store playlists with their IDs as keys
    private final Map<Long,Playlist> playlistSack;

    // Constructor to initialize the repository
    public PlaylistRepository(){
        playlistSack = new HashMap<Long,Playlist>();
    }

    // Saves a new playlist to the repository and generates an ID for it
    public void save(Playlist pl) {
        pl.setId(autoIncrement);
        playlistSack.putIfAbsent(autoIncrement++, pl);
    }

    // Returns a list of song names in the playlist with the given ID
    public List<String> getPlaylistbyID(Long ID){
        return new ArrayList<>();
    }

    // Returns the playlist with the given name
    public Playlist getPlaylistbyName(String playlistName) {
        for(Playlist pl : playlistSack.values()){
            if(pl.getName().equals(playlistName))  return pl;
        }
        // Throws a RuntimeException if no playlist with the given name is found
        throw new RuntimeException("There is no playlist with such name ! ");
    }

    // Removes the playlist with the given name from the repository
    public Playlist delPl(String playlistName) {
        return playlistSack.remove(getPlaylistbyName(playlistName).getId());
    }
    
}
