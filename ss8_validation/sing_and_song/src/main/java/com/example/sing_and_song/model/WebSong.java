package com.example.sing_and_song.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class WebSong implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String songName;
    private String artist;
    private String musicType;


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        WebSong webSong = (WebSong) target;
        if (webSong.getSongName().equals("")) {
            errors.rejectValue("songName", null, "Not Empty");
        } else if (!webSong.getSongName().matches("^(?!\\s)(?!.*\\s$).{1,800}$")) {
            errors.rejectValue("songName", null, "1-800 Character");
        } else if (!webSong.getSongName().matches("^[^\\W_@;,.=\\-+…]+$")) {
            errors.rejectValue("songName", null, "Dont have @ ; , . = - +");
        }
        if (webSong.getArtist().equals("")) {
            errors.rejectValue("artist", null, "Not Empty");
        } else if (!webSong.getArtist().matches("^(?!\\s)(?!.*\\s$).{1,300}$")) {
            errors.rejectValue("artist", null, "1-300 Character");
        } else if (!webSong.getArtist().matches("^[^\\W_@;,.=\\-+…]+$")) {
            errors.rejectValue("artist", null, "Dont have @ ; , . = - +");
        }
        if (webSong.getMusicType().equals("")) {
            errors.rejectValue("musicType", null, "Not Empty");
        } else if (!webSong.getMusicType().matches("^(?!\\s)(?!.*\\s$).{1,1000}$")) {
            errors.rejectValue("musicType", null, "1-1000 Character");
        } else if (!webSong.getMusicType().matches("^[a-zA-Z0-9\\s,]*$")) {
            errors.rejectValue("musicType", null, "Except ,");
        }
    }
}
