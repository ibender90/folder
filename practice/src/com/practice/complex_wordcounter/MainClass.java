package com.practice.complex_wordcounter;

import java.util.Map;
import java.util.Scanner;

public class MainClass { // программа может принимать только название txt файла с рабочего стола, может посчитать слова или вывести повторяющиеся
    public static void main(String[] args) {

        Scanner scannedFile2 = FileReader.fileFromDesktop();
        Map<String, Integer> counted = WordSaver.countEveryWord(scannedFile2);
        WordSaver.simplePrint(counted);
        WordSaver.sortedPrint(counted);
        WordSaver.thisWordRepeats(counted,"line");
        scannedFile2.close();

    }
}
