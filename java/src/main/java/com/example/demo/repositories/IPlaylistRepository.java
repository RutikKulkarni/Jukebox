package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Playlist;

public interface IPlaylistRepository {
    // Save the playlist to the database
    void save(Playlist pl);
    // Get the list of songs in a playlist by its Id
    List<String> getPlaylistbyID(Long ID);
    // Get the playlist by its name
    Playlist getPlaylistbyName(String playlistName);
    // Delete a playlist by its name
    Playlist delPl(String playlistName);
}
