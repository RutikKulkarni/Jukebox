package com.example.demo.commands;


import java.util.LinkedList;
import java.util.List;
import com.example.demo.entities.Playlist;
import com.example.demo.entities.Songs;
import com.example.demo.services.PlaylistServices;
import com.example.demo.services.SongService;


public class CreatePlaylistCommand implements ICommand {
    // The PlaylistServices and SongService dependencies are injected through the constructor
    private final PlaylistServices playlistService;
    private final SongService songService ;
    // Create playlist command
    public CreatePlaylistCommand(PlaylistServices playlistService,SongService songService) {
            this.playlistService = playlistService;
            this.songService = songService;
    }
    
    @Override
    public void invoke(List<String> tokens) {
        // Extract the playlist name and song ids from the tokens list
        String playlistName = tokens.get(1);
        LinkedList<Songs> songList = new LinkedList<>();
        for(int i = 2;i < tokens.size();i++){
            Long id = Long.valueOf(tokens.get(i));
            songList.add(songService.findbyId(id));
        }
        // Create the playlist using the PlaylistServices instance
        Playlist createplaylist = playlistService.createPlaylist(playlistName, songList);
        
        System.out.println(createplaylist.toString());
    }
    
}