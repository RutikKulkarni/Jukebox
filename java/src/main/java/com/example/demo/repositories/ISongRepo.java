package com.example.demo.repositories;

import java.util.List;
import com.example.demo.entities.Songs;

public interface ISongRepo {
    // Saves a song to the database.
    void save(Songs song);
    // Returns a list of all songs in the database.
    List<String> findall();
    // Finds and returns a song from the database by its ID
    Songs findbyId(Long id);
}
