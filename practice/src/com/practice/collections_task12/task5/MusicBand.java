package com.practice.collections_task12.task5;

import java.util.ArrayList;
import java.util.List;

public class MusicBand {
    private String name;
    private int year;
    private List<Artist> member = new ArrayList<>();

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void addMember(Artist artist) {
        member.add(artist);
    }


    public void printMembers() {
        System.out.println(this.member);
    }

    public int getYear() {
        return year;
    }

    public static void transferMembers(MusicBand band1, MusicBand band2) { //from second band to first
        band1.member.addAll(band2.member);
        band2.member.clear();
    }

    @Override
    public String toString() {
        return "MusicBand{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }
}
