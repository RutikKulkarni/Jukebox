package com.example.demo.services;

import java.util.LinkedList;
import com.example.demo.entities.Songs;

public class PlayerService {
    // Constructor
    public PlayerService(){}
    // LinkedList to hold the playlist
    private LinkedList<Songs> playList;
    // Setter for playlist
    public void setPlaylist(LinkedList<Songs> pList){
        playList = pList;
    }

    // Returns the first song in the playlist
    public Songs play(){
        return playList.peek();
    }

    // Advances to the next song in the playlist by moving the first element to the end, and returning the new first element
    public Songs nextSong() {
        playList.addLast(playList.pollFirst());
        return playList.peek();
    }

    // Goes back to the previous song in the playlist by moving the last element to the beginning and returning the last element
    public Songs previousSong() {
        Songs s = playList.getLast();
        playList.addFirst(playList.pollLast());
        return s;
    }

    // Stops the current playlist by setting it to null and returns the song that was being played
    public Songs stop() {
        Songs s = playList.peek();
        playList = null;
        return s;
    }
}
