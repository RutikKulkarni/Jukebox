package com.example.demo;

import com.example.demo.commands.AddSongtoPLCommand;
import com.example.demo.commands.CommandKeyword;
import com.example.demo.commands.CommandRegistry;
import com.example.demo.commands.CreateGreetingCommand;
import com.example.demo.commands.CreatePlaylistCommand;
import com.example.demo.commands.CreateSongCommand;
import com.example.demo.commands.DeletePLCommand;
import com.example.demo.commands.DeleteSongfromPL;
import com.example.demo.commands.GetGreetingCommand;
import com.example.demo.commands.ListGreetingCommand;
import com.example.demo.commands.ListSongCommand;
import com.example.demo.commands.LoadPlaylistCommand;
import com.example.demo.commands.NextSongCommand;
import com.example.demo.commands.PlaySongCommand;
import com.example.demo.commands.PreviousSongCommand;
import com.example.demo.commands.StopSongCommand;
import com.example.demo.repositories.GreetingRepository;
import com.example.demo.repositories.IGreetingRepository;
import com.example.demo.repositories.IPlaylistRepository;
import com.example.demo.repositories.ISongRepo;
import com.example.demo.repositories.PlaylistRepository;
import com.example.demo.repositories.SongRepo;
import com.example.demo.services.GreetingService;
import com.example.demo.services.PlayerService;
import com.example.demo.services.PlaylistServices;
import com.example.demo.services.SongService;

public class Configuration {
            // Singleton Pattern
            //create an object of Single Configuration Object
            private static Configuration instance = new Configuration();

            //make the constructor private so that this class cannot be
            //instantiated
            private Configuration(){}

            //Get the only object available
            public static Configuration getInstance(){
                return instance;
            }

    		// Initialize repositories
            private final IGreetingRepository greetingRepository = new GreetingRepository();
            private final ISongRepo songRepo = new SongRepo();
            private final IPlaylistRepository playRepo = new PlaylistRepository();
    
            // Initialize services
            private final GreetingService greetingService = new GreetingService(greetingRepository);
            private final SongService songService = new SongService(songRepo);
            private final PlayerService playerService = new PlayerService();
            private final PlaylistServices playlistServices = new PlaylistServices(playRepo,songRepo,playerService);

            // Initialize commands
            private final CreateGreetingCommand createGreetingCommand = new CreateGreetingCommand(greetingService);
            private final ListGreetingCommand listGreetingCommand = new ListGreetingCommand(greetingService);
            private final GetGreetingCommand  getGreetingCommand = new GetGreetingCommand(greetingService);
            private final CreateSongCommand createSongCommand = new CreateSongCommand(songService);
            private final ListSongCommand listSongCommand = new ListSongCommand(songService);
            private final CreatePlaylistCommand createPlaylistCommand = new CreatePlaylistCommand(playlistServices,songService);
            private final LoadPlaylistCommand loadPlaylistCommand = new LoadPlaylistCommand(playlistServices);
            private final AddSongtoPLCommand addSongtoPLCommand = new AddSongtoPLCommand(playlistServices);
            private final DeleteSongfromPL delSongfromoPLCommand = new DeleteSongfromPL(playlistServices);
            private final DeletePLCommand deletePLCommand = new DeletePLCommand(playlistServices);
            private final PlaySongCommand playSongCommand = new PlaySongCommand(playerService);
            private final NextSongCommand nextSongCommand = new NextSongCommand(playerService);
            private final PreviousSongCommand prevSongCommand = new PreviousSongCommand(playerService);
            private final StopSongCommand stopSongCommand = new StopSongCommand(playerService);

            // Initialize commandRegistery
            private final CommandRegistry commandRegistry = new CommandRegistry();

            // Register commands 
            private void registerCommands(){
                commandRegistry.registerCommand(CommandKeyword.CREATE_GREETING_COMMAND.getName(),createGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.LIST_GREETING_COMMAND.getName(),listGreetingCommand);
                commandRegistry.registerCommand(CommandKeyword.GET_GREETING_COMMAND.getName(),getGreetingCommand);

                // All song commands
                commandRegistry.registerCommand(CommandKeyword.CREATE_SONG_COMMAND.getName(),createSongCommand); // to create the cong
                // to get list of songs
                commandRegistry.registerCommand(CommandKeyword.LIST_SONG_COMMAND.getName(),listSongCommand); 

                // All Play list commands
                commandRegistry.registerCommand(CommandKeyword.CREATE_PLAYLIST_COMMAND.getName(),createPlaylistCommand); // to create play list od command
                // to load the playlist 
                commandRegistry.registerCommand(CommandKeyword.LOAD_PLAYLIST_COMMAND.getName(),loadPlaylistCommand); 
                // to add the song in play list
                commandRegistry.registerCommand(CommandKeyword.ADD_SONG_TO_PL.getName(),addSongtoPLCommand); 
                // to delete the song from the playlist
                commandRegistry.registerCommand(CommandKeyword.DEL_SONG_FROM_PL.getName(),delSongfromoPLCommand); 
                // to delete the playlist
                commandRegistry.registerCommand(CommandKeyword.DEL_PL.getName(),deletePLCommand);

                // All player commands
                commandRegistry.registerCommand(CommandKeyword.PLAY_SONG.getName(),playSongCommand); // to play the song
                // To change the song
                commandRegistry.registerCommand(CommandKeyword.NEXT_SONG.getName(),nextSongCommand);
                //  to go on the previous song
                commandRegistry.registerCommand(CommandKeyword.PREVIOUS_SONG.getName(),prevSongCommand);
                // to stop the playing song
                commandRegistry.registerCommand(CommandKeyword.STOP_SONG.getName(),stopSongCommand);
            }
            
            public CommandRegistry getCommandRegistry(){
                registerCommands();
                return commandRegistry;
            }
}
