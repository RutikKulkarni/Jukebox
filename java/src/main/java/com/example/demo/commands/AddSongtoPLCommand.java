package com.example.demo.commands;

import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.services.PlaylistServices;

public class AddSongtoPLCommand implements ICommand{
    // An instance of the PlaylistServices interface
    private final PlaylistServices playlistService; 

    public AddSongtoPLCommand(PlaylistServices playlistService) {
            this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // get the name of the playlist from the tokens list
        String playlistName = tokens.get(1);
        // get the ID of the song from the tokens list
        String songid = tokens.get(2);
        // add the song to the playlist using the PlaylistServices object
        Playlist addSongtoPL = playlistService.addSongtoPlaylist(playlistName, songid);
        // print a message indicating that the playlist has been updated with the new song
        System.out.println("Playlist "+addSongtoPL.getName()+" is revised with " + addSongtoPL.getPlaylist());
    }
}
