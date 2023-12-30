package com.example.demo.entities;

import java.util.LinkedList;
import com.example.demo.services.PlayerService;


public class Player {
    // list of songs to play
    private  LinkedList<Songs> playList;
    public Player(LinkedList<Songs> playList,PlayerService playerService){
        // initialize the playlist
        this.playList = playList;
    }

    public void setPlaylist(LinkedList<Songs> pList){
        // set the playlist to a new list of songs
        playList = pList;
    }

    public Songs play(){
        // get the first song in the playlist
        return playList.peek();
    }

}
