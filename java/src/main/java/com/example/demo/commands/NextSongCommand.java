package com.example.demo.commands;

import com.example.demo.entities.Songs;
import com.example.demo.services.PlayerService;
import java.util.List;

public class NextSongCommand implements ICommand{
    private final PlayerService playerService; 

    // Creates a NextSongCommand object with the given PlayerService object.    
    public NextSongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    // Plays the next song in the current playlist using the PlayerService object.
    @Override
    public void invoke(List<String> tokens) {
        Songs s = playerService.nextSong();
        System.out.println(s.toString()+" is playing!");
    }
}
