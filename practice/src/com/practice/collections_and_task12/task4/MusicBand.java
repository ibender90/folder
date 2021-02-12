package com.practice.collections_and_task12.task4;

import java.util.ArrayList;
import java.util.List;

//Скопировать MusicBand из прошлого задания и доработать таким образом, чтобы в
//        группу можно было добавлять и удалять участников. Под участником понимается
//        строка ( String ) с именем и фамилией. Реализовать статический метод слияния групп
//        (в классе MusicBand ), т.е. все участники группы А переходят в группу B . Название
//        метода: transferMembers . Этот метод принимает в качестве аргументов два
//        экземпляра класса MusicBand . Реализовать метод printMembers (в классе
//        MusicBand ), выводящий список участников в консоль. Проверить состав групп после
//        слияния.
public class MusicBand {
    private String name;
    private int year;
    private List<String> member = new ArrayList<>();

    public MusicBand(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public void addMember(String name, String surname) {
        String element = name + " " + surname;
        member.add(element);
    }

    public void removeMember(String who) {
        String goodbye = String.valueOf(who);
        member.remove(goodbye);
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
