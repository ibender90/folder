package com.practice.collections_task12.task5;

public class Artist {
    private String name;
    private int age;

    public Artist(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
