package com.example.demo.commands;

public enum CommandKeyword {

    // Register Command Keywords
    CREATE_GREETING_COMMAND("CREATE_GREETING"),
    LIST_GREETING_COMMAND ("LIST_GREETING"),
    GET_GREETING_COMMAND ("GET_GREETING"),
    // To add song
    CREATE_SONG_COMMAND ("ADD_SONG"),
    // List of songs
    LIST_SONG_COMMAND ("LIST_SONGS"),
    // To creare a playlist
    CREATE_PLAYLIST_COMMAND ("CREATE_PLAYLIST"),
    // To load the playlist
    LOAD_PLAYLIST_COMMAND("LOAD_PLAYLIST"),
    // Add songs in the playlist
    ADD_SONG_TO_PL("ADD_SONG_TO_PLAYLIST"),
    // To delete the song from the playlist
    DEL_SONG_FROM_PL("DELETE_SONG_FROM_PLAYLIST"),
    // Delete the entire playlist
    DEL_PL("DELETE_PLAYLIST"),
    // To play the song
    PLAY_SONG("PLAY_SONG"),
    // To Change the song (Next)
    NEXT_SONG("NEXT_SONG"),
    // To go back on previous song
    PREVIOUS_SONG("PREVIOUS_SONG"),
    // Stop the played song
    STOP_SONG("STOP_SONG");

    private final String name;
    private CommandKeyword(String name){
        this.name = name;
    }

    public String getName() {
        return name;
     } 
}
