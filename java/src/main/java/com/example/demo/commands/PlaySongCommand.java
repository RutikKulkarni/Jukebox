package com.example.demo.commands;

import com.example.demo.entities.Songs;
import com.example.demo.services.PlayerService;
import java.util.List;

public class PlaySongCommand implements ICommand{
    private final PlayerService playerService; 
    // counter to keep track of play/pause state
    private int count = 2;

    public PlaySongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // get the next song to play
        Songs s = playerService.play();
        // if the counter is even, the song is playing
        if(count % 2 == 0) System.out.println(s.toString()+" is playing!");
        // if the counter is odd, the song is paused
        else System.out.println(s.toString()+" is paused!");
        count++;
    }
}
