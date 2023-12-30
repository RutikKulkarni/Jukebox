package com.example.demo.commands;

import com.example.demo.entities.Songs;
import com.example.demo.services.PlayerService;
import java.util.List;

public class StopSongCommand implements ICommand{
    // The player service used to stop the current song
    private final PlayerService playerService; 

    public StopSongCommand(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // Stop the current song
        Songs s = playerService.stop();
        System.out.println(s.toString()+" is stopped!");
    }
}
