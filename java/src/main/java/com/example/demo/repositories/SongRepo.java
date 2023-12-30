package com.example.demo.repositories;

import java.util.*;
import java.util.stream.Collectors;
import com.example.demo.entities.Songs;

public class SongRepo implements ISongRepo{
    // field to track the ID of the next song to be added
    private Long autoIncrement = 1L;

    // map to store the songs, using their IDs as keys
    private final Map<Long,Songs> songsSack;
    
    public SongRepo(){
        songsSack = new HashMap<Long,Songs>();
    }
    
    // saves a song to the repository
    public void save(Songs song){
        song.setId(autoIncrement);
        songsSack.putIfAbsent(autoIncrement++, song);
    }

    // returns a list of all songs in the repository, as strings
    public List<String> findall() {
        return songsSack.values().stream().map(Object::toString).collect(Collectors.toList());
        
    }

    // finds and returns a song in the repository by its ID
    public Songs findbyId(Long id){
        return songsSack.get(id);
    }

}
