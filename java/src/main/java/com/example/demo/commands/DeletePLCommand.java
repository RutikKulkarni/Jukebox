package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistServices;

public class DeletePLCommand implements ICommand{
    private final PlaylistServices playlistService; 
    //  Create a DeletePLCommand with a PlaylistServices instance.
    public DeletePLCommand(PlaylistServices playlistService) {
            this.playlistService = playlistService;
    }

    // Deletes the playlist with the given name and prints a success message if successful.
    @Override
    public void invoke(List<String> tokens) {
        String playlistName = tokens.get(1);
        Playlist delplaylist = playlistService.delPlaylist(playlistName);
        System.out.println("Playlist "+ delplaylist.getName()+" is deleted!");
    }
}