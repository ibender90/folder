package com.practice.complex_wordcounter;

import java.util.Scanner;

public class Main { // программа может принимать только название txt файла с рабочего стола, может посчитать слова или вывести повторяющиеся
    public static void main(String[] args) {
//        Scanner scannedFile1 = InputProcessing.fileFromDesktop();
//        System.out.println("This file has " + SimpleWordCounter.countWords(scannedFile1)+ " words");
//        scannedFile1.close();

        Scanner scannedFile2 = InputProcessing.fileFromDesktop();
        EveryWordCounter.everyWord(scannedFile2);
        scannedFile2.close();
    }
}
