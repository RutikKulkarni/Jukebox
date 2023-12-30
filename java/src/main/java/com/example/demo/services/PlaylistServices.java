package com.example.demo.services;

import java.util.LinkedList;
import com.example.demo.entities.Playlist;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepo;
import com.example.demo.entities.Songs;

public class PlaylistServices {
    private final IPlaylistRepository iPlaylistRepository;
    private final ISongRepo iSongRepo;
    private final PlayerService playerService;

    // Constructor to initialize IPlaylistRepository, ISongRepo and PlayerService.
    public PlaylistServices(IPlaylistRepository iPlaylistRepository,ISongRepo iSongRepo,PlayerService playerService){
        this.iPlaylistRepository = iPlaylistRepository;
        this.iSongRepo = iSongRepo;
        this.playerService = playerService;
    }

    // Creates a new playlist with the given name and list of songs and saves it in the playlist repository.
    public Playlist createPlaylist(String playlistName,LinkedList<Songs> songList){
        Playlist pl = new Playlist(playlistName,songList);
        iPlaylistRepository.save(pl);
        return pl;
    }

    // Loads the playlist with the given name from the playlist repository and sets it as the current playlist in the player service.
    public Playlist loadPlaylist(String playlistName) {
        Playlist p = iPlaylistRepository.getPlaylistbyName(playlistName);
        LinkedList<Songs> pl = (p.getPlaylist());
        playerService.setPlaylist(pl);
        return p;
    }

    // Adds a song with the given id to the playlist with the given name.
    public Playlist addSongtoPlaylist(String playListname,String id){
        iPlaylistRepository.getPlaylistbyName(playListname).getPlaylist().add(iSongRepo.findbyId(Long.valueOf(id)));
        return iPlaylistRepository.getPlaylistbyName(playListname);
    }

    // Removes a song with the given id from the playlist with the given name.
    public Playlist deleteSongfromPlaylist(String playListname,String id){
        iPlaylistRepository.getPlaylistbyName(playListname).getPlaylist().remove(iSongRepo.findbyId(Long.valueOf(id)));
        return iPlaylistRepository.getPlaylistbyName(playListname);
    }

    // Deletes the playlist with the given name from the playlist repository.
    public Playlist delPlaylist(String playlistName) {
        return iPlaylistRepository.delPl(playlistName);
    }
}
