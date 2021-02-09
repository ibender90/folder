package com.practice.sixteen_files_numbers_casting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*1. Реализовать программу, которая на вход принимает txt файл с целыми числами
        (можно использовать файл из задания 1 дня 14) и в качестве ответа выводит в
        консоль среднее арифметическое этих чисел.
        Ответ будет являться вещественным числом. В консоль необходимо вывести полную
        запись вещественного числа (со всеми знаками после запятой) и сокращенную запись
        (с 3 знаками после запятой).*/
public class Task1 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("files/some_text");
        printResult(file);

    }
    public static void printResult(File file) throws FileNotFoundException {
        Scanner scannedFile = new Scanner(file);
        String[] scannedLine = scannedFile.nextLine().split(" ");
        int sum = 0;
        double average;
        for (String element : scannedLine) {
            sum += Integer.parseInt(element);
        }
        average = sum / (double)scannedLine.length; // знаменатель нужно привести к вещественному числу (int / int = int)
        System.out.printf("%f%n", average);
        System.out.printf("%.3f%n", average); // printf .3f указывает, что мы хотим видеть 3 числа после запятой
    }
}
