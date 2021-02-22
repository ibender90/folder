package com.practice.maxima;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Random;

public class GoodsGenerator {

    public static void writeWithFormatter() throws FileNotFoundException {
        Formatter formatter = new Formatter("GeneratedGoods.txt");
        int counter = 0;
        int firtsLine = 12_345_678;
        while (counter < 10000) {
            try {
                formatter.format("%-8d%s%n", (firtsLine), generateName());
                counter++;
                firtsLine-=1200;
            } catch (InputMismatchException e) {
                System.out.println("Incorrect input");
            }
        }
        formatter.close();
    }


    private static String generateName(){
        Random random = new Random();
        char[] name = new char[10];
        for(int i = 0; i<10; i++){
            name[i] = (char) ('a' + random.nextInt(26));
        }
        return String.valueOf(name);
    }
}
