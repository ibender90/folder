package com.practice.complex_wordcounter;

import java.util.Scanner;
import java.util.StringTokenizer;

public class WordCounter {

    public static int countWords(Scanner scanner) {
        int amountOfWords = 0;
        while (scanner.hasNextLine()) {
            String scannedLines = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(scannedLines, "^%$#*'\\\\\" ,\\?!@:;-\\+&/\\.\\(\\)");
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (!isNumber(token)) {
                    amountOfWords++;
                }
            }
        }
        return amountOfWords;
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
