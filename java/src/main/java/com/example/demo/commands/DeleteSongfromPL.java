package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistServices;

public class DeleteSongfromPL implements ICommand{
    private final PlaylistServices playlistService; 
    // Constructor to inject PlaylistServices dependency
    public DeleteSongfromPL(PlaylistServices playlistService) {
            this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // Get the playlist name and song id from the command tokens
        String playlistName = tokens.get(1);
        String songid = tokens.get(2);
        // Call the service method to delete the song from the playlist
        Playlist delSongfromPL = playlistService.deleteSongfromPlaylist(playlistName, songid);
        
        System.out.println("Playlist "+delSongfromPL.getName()+" is revised with " + delSongfromPL.getPlaylist());
    }

}