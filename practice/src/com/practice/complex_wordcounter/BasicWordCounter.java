package com.practice.complex_wordcounter;

import java.util.Scanner;

public class BasicWordCounter {
    public static int countWords(Scanner scanner) {
        int amountOfWords = 0;
        while (scanner.hasNextLine()) {
            String scannedLines = scanner.nextLine();
            String[] line = scannedLines.split(" ");
            amountOfWords += line.length; //+= потому, что каждую строку массив обновляется
            for (String word : line) {
                if (isNumber(word) || isSign(word)) {
                    amountOfWords--;
                }  //уменьшу счётчик слов если встречу число
            }
        }
        return amountOfWords;
    }
    public static boolean isSign(String str){
        switch (str) {
            case "!", "?", ",", ":", ";", "-" -> {
                return true; // проверяю не попался ли мне просто отдельный знак препинания
            }
        } return false;
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
