package com.practice.lambdas;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaExample {
    public static void main(String[] args) {
        Player player1 = new Player("Kos", 10);
        Player player2 = new Player("Anton", 5);
        Player player3 = new Player("Dima", 6);

        Player[] team = {player1, player2, player3};

        Arrays.sort(team, new Comparator<Player>() { //пример анонимного класса
            @Override
            public int compare(Player p1, Player p2) {
                return p1.score - p2.score; //от меньшего счёта к большему
            }
        });

        //пример лямбда выражения из нескольких строк, тело метода заключено в скобки
        Arrays.sort(team, (p1, p2) -> {
            if ((p1.score - p2.score) != 0) {
                return p1.score - p2.score;
            } else return p1.name.compareTo(p2.name);
        });

        System.out.println(Arrays.toString(team));

        String[] colors = {"red", "green", "blue", "orcha"};

//        Arrays.sort(colors, new Comparator<String>() { //сравниваем по последней букве в строке
//            @Override
//            public int compare(String color1, String color2) {
//                return color1.charAt(color1.length() - 1) - color2.charAt(color2.length() - 1);
//            }
//        });

        //                   входные параметры -> тело метода
        Arrays.sort(colors, (color1, color2) -> color1.charAt(color1.length() - 1) - color2.charAt(color2.length() - 1));
        //                   () скобки нужны для лямбда выражения даже если нет аргументов

        System.out.println(Arrays.toString(colors));
    }
}
