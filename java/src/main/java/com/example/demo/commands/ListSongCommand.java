package com.example.demo.commands;

import com.example.demo.services.SongService;
import java.util.*;

public class ListSongCommand implements ICommand {

    private final SongService songService; 
    public ListSongCommand(SongService songService) {
            this.songService = songService;
    }

    // This method retrieves a list of all songs from the song service and prints it to the console
    public void invoke(List<String> tokens) {
        List<String> slist = songService.getAllSongs();
        System.out.println(slist);
    }

}
