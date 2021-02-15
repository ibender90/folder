package com.practice.complex_wordcounter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputProcessing { //if I have a text file on my desktop, I can give its name to this class
    public static Scanner fileFromDesktop() {
        String separator = File.separator;
        Scanner nameScanner = new Scanner(System.in);
        Scanner fileScanner;
        do {
            System.out.println("please enter file name");
            String fileName = nameScanner.next();
            try {
                String path = "C:" + separator + "Users" + separator + "Bender Desktop" + separator + "Desktop" + separator + fileName + ".txt";
                File myFile = new File(path);
                fileScanner = new Scanner(myFile);
                break;
            } catch (FileNotFoundException | NullPointerException e) {
                System.out.println("file not found");
            }
        } while (true);
        return fileScanner;
    }
}
