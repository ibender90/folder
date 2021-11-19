package ru.alishev.springcourse;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ClassicalMusic implements Music{

    private ClassicalMusic(){}; // closing access to user to make new objects of this class

    public static ClassicalMusic makeClassicalMusicObject(){ //static! because we need to call it from class
        return new ClassicalMusic();
    }

    @Override
    public String getSong(int number) {
        List<String> playList = new LinkedList<>();
        playList.add("Symphony nr5");
        playList.add("Swans lake");
        playList.add("Winter");
        if(number <= 3){
            return playList.get(number);}
        else return "playlist is emppty";
    }
}
