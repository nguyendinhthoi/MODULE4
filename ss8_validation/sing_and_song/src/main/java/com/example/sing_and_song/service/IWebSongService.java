package com.example.sing_and_song.service;

import com.example.sing_and_song.model.WebSong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IWebSongService {
    void saveSong(WebSong webSong);

    Page<WebSong> searchByName(Pageable pageable, String searchName);

    WebSong findById(int id);

    void updateSong(WebSong webSong,int id);
}
