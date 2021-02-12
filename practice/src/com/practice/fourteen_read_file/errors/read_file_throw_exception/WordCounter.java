package com.practice.fourteen_read_file.errors.read_file_throw_exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class WordCounter {
    public static void main(String[] args) {
        String separator = File.separator; // получаем от ОС правильный формат разделения директорий /
        String path = "C:" + separator + "Users" + separator + "Bender Desktop" + separator + "Desktop" + separator + "test.txt";

        File myFile = new File(path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

//        while (scanner.hasNextLine()) {
//            System.out.println(scanner.nextLine()); // пока сканер получает не пустую строку выводим их в консоль
//        }
//        scanner.close(); // закрываем сканер
//        String scannedLine = scanner.nextLine(); //сканируем только первую строку
//        String[] words = scannedLine.split(" "); //scannedLine разделяется пробелами, значения сохраняются в массив words
//        int[] numbers = new int[3];
//        int counter = 0;
//        for(String element: words){
//            numbers[counter++] = Integer.parseInt(element); //если мы знаем, что файл содержит только целые числа, можем получить массив чисел из массива строк
//        }
        int amountOfWords = 0;
        int amountOfNumbers = 0;
        while (scanner.hasNextLine()) {
            String scannedLines = scanner.nextLine();
            String[] line = scannedLines.split(" ");
            amountOfWords += line.length; //+= потому, что каждую строку массив обновляется

            for (String word : line) {
                if (isNumber(word)) {
                    amountOfWords--;
                } //уменьшу счётчик слов если встречу число
                switch (word) {
                    case "!", "?", ",", ":", ";", "-" -> amountOfWords--; // проверяю не попался ли мне просто отдельный знак препинания
                }
            }
        }
        scanner.close();

        System.out.println(amountOfWords);
        //System.out.println((isNumber("444")));
    }
    public static boolean isNumber(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }


}

