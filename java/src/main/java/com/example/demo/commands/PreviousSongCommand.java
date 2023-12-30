package com.example.demo.commands;

import com.example.demo.entities.Songs;
import com.example.demo.services.PlayerService;
import java.util.List;

public class PreviousSongCommand implements ICommand{
    private final PlayerService playerService; 

    // Constructor that injects the PlayerService
    public PreviousSongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // Call the PlayerService's previousSong method to get the previous song
        Songs s = playerService.previousSong();
        System.out.println(s.toString()+" is playing!");
    }
}
