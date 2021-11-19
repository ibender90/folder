package ru.alishev.springcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class MusicPlayer {

    //@Qualifier("rockMusic") to specify which bean to use if we have several options

    private Music music1;  // use interface to play any genre
    private Music music2;

    @Value("${musicPlayer.playerName}") //annotation is used to take value from file
    private String playerName;

    @Value("${musicPlayer.volume}")
    private int volume;

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1, @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    //public MusicPlayer(Music music){
    //   this.music = music; //inversion of control
    //}

    public MusicPlayer(){} //empty constructor is needed to use setter instead of another constructor


    public void play(Genre genre){
        Random randomSong = new Random();
        int song = randomSong.nextInt(3);
        Music someMusic;
        if(genre == Genre.ROCK){
            someMusic = music1;
        } else { someMusic = music2;}
        System.out.println("Now playing: " + someMusic.getSong(song));
//        int amountOfSongs = music.size();
//        for(int i = 0; i < amountOfSongs; i++) {
//            System.out.println("Now playing: " + music.get(i).getSong()); //get method is implemented by different genres
//
//        }
    }
}
