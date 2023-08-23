package com.example.sing_and_song.repository;

import com.example.sing_and_song.model.WebSong;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IWebSongRepository extends JpaRepository<WebSong,Integer> {
    @Transactional
    @Modifying
    @Query(value = "insert into web_song(song_name,artist,music_type) " +
            "values (:#{#webSong.songName},:#{#webSong.artist},:#{#webSong.songName})",nativeQuery = true)
    void saveSong(WebSong webSong);


    @Query(value = "select * from web_song where song_name like :name", nativeQuery = true)
    Page<WebSong> searchByName(Pageable pageable, @Param("name") String searchName);
    @Query(value = "select * from web_song where id = :id", nativeQuery = true)
    WebSong findById(@Param("id") int id);
    @Transactional
    @Modifying
    @Query(value = "update web_song set song_name = :#(#webSong.songName), artist = :#{#webSong.artist}, music_type = :#{#webSong.songName} where id = :id1", nativeQuery = true)
    void updateSong(WebSong webSong,@Param("id1") int id1);
}
