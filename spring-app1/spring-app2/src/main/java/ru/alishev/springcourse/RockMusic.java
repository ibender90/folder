package ru.alishev.springcourse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
@Scope("singleton")
public class RockMusic implements Music{
    @Override
    public String getSong(int number) {
        List<String> playList = new LinkedList<>();
        playList.add("Lonely day");
        playList.add("Beautiful people");
        playList.add("My way");
        if(number <= 3){
        return playList.get(number);}
        else return "playlist is emppty";
    }
}
