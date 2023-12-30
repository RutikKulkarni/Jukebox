package com.example.demo.commands;
import com.example.demo.services.SongService;
import com.example.demo.entities.Songs;
import java.util.*;

// Create a song command that creates a new song and adds it to the song service.
public class CreateSongCommand implements ICommand {
    private final SongService songService; 
    // Creates a new CreateSongCommand with the given SongService.
    public CreateSongCommand(SongService songService) {
            this.songService = songService;
    }

    // Invokes the CreateSongCommand with the given list of tokens.
    public void invoke(List<String> tokens) {
        String songName = tokens.get(1);
        String artist = tokens.get(2);
        String album = tokens.get(3);
        String genre = tokens.get(4);
        Songs createSong = songService.addSong(songName,artist, album, genre);
        System.out.println(createSong.toString());
    }
}