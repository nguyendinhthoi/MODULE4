package com.example.sing_and_song.service;

import com.example.sing_and_song.model.WebSong;
import com.example.sing_and_song.repository.IWebSongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class WebSongService implements IWebSongService {
    @Autowired
    IWebSongRepository webSongRepository;

    @Override
    public void saveSong(WebSong webSong) {
        webSongRepository.saveSong(webSong);
    }

    @Override
    public Page<WebSong> searchByName(Pageable pageable, String searchName) {
        return webSongRepository.searchByName(pageable, "%" + searchName + "%");
    }

    @Override
    public WebSong findById(int id) {
       return webSongRepository.findById(id);
    }

    @Override
    public void updateSong(WebSong webSong, int id) {
        webSongRepository.updateSong(webSong,id);
    }
}
