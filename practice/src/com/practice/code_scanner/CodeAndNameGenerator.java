package com.practice.code_scanner;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Random;

public class CodeAndNameGenerator {

    public static void writeWithFormatter() throws FileNotFoundException {
        Formatter formatter = new Formatter("GeneratedGoods.txt");
        int counter1 = 0;
        int counter2 = 0;
        int firstLine = 12_345_678;
        while (counter1 < 10000) {
            try {
                formatter.format("%-8d%s%n", (firstLine), generateName());
                firstLine-=1;
                counter1++;
                counter2++;
                if (counter2 == 2400){
                    firstLine = firstLine/10;
                    counter2 = 0;
                }
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
