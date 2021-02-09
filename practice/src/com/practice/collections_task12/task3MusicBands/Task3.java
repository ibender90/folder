package com.practice.collections_task12.task3MusicBands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        MusicBand mb1 = new MusicBand("Foo Fighters", 1994);
        MusicBand mb2 = new MusicBand("Nirvana", 1987);
        MusicBand mb3 = new MusicBand("Pearl Jam", 1990);
        MusicBand mb4 = new MusicBand("Red Hot Chilly Peppers", 1983);
        MusicBand mb5 = new MusicBand("Green Day", 1986);
        MusicBand mb6 = new MusicBand("Blink - 182", 2000);
        MusicBand mb7 = new MusicBand("Linkin Park", 2001);
        MusicBand mb8 = new MusicBand("Limp Bizkit", 2005);
        MusicBand mb9 = new MusicBand("Eminem", 2004);
        MusicBand mb10 = new MusicBand("System of a down", 2008);

        List<MusicBand> mbList = new ArrayList<>();
        mbList.add(mb1);
        mbList.add(mb2);
        mbList.add(mb3);
        mbList.add(mb4);
        mbList.add(mb5);
        mbList.add(mb6);
        mbList.add(mb7);
        mbList.add(mb8);
        mbList.add(mb9);
        mbList.add(mb10);

        Collections.shuffle(mbList);
        System.out.println(mbList);
        System.out.println(groupsAfter2000(mbList));

    }
        public static List<MusicBand> groupsAfter2000(List<MusicBand> someGroupList){
        List<MusicBand> groupsAfter2000 = new ArrayList<>();
        for(MusicBand element : someGroupList){
            if(element.getYear() >= 2000){
                groupsAfter2000.add(element);
            }
        }
        return groupsAfter2000;

    }
}
