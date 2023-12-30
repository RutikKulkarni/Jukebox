package com.example.demo.commands;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.services.PlaylistServices;

public class LoadPlaylistCommand implements ICommand{
    private final PlaylistServices playlistService; 
    PlaylistRepository playlistRepository;
    // Constructor with PlaylistServices dependency injection
    public LoadPlaylistCommand(PlaylistServices playlistService) {
            this.playlistService = playlistService;
    }

    @Override
    public void invoke(List<String> tokens) {
        // Get the name of the playlist to be loaded from the tokens list
        String playlistName = tokens.get(1);
        // Call the playlistService's loadPlaylist method to load the playlist from the repository
        Playlist playlist = playlistService.loadPlaylist(playlistName);
        System.out.println("Playlist "+playlist.getName()+" is loaded!");
        
    }
}
