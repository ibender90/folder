package com.practice.complex_wordcounter;

import java.util.Map;
import java.util.Scanner;

public class MainTask { // программа может принимать только название txt файла с рабочего стола, может посчитать слова или вывести повторяющиеся
    public static void main(String[] args) {
//        Scanner scannedFile1 = InputProcessing.fileFromDesktop();
//        System.out.println("This file has " + SimpleWordCounter.countWords(scannedFile1)+ " words");
//        scannedFile1.close();

        Scanner scannedFile2 = InputProcessing.fileFromDesktop();
        Map<String, Integer> counted = EveryWordCounter.countEveryWord(scannedFile2);
        //EveryWordCounter.simplePrint(counted);
        EveryWordCounter.sortedPrint(counted);
        scannedFile2.close();

    }
}
