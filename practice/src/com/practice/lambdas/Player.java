package com.practice.lambdas;

public class Player {
    public String name;
    public int score;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Fplayer{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
