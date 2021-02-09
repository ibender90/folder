package com.practice.fourteen_read_file.errors.read_file_throw_exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainException {
    public static void main(String[] args) {
        try {
            readFile();
        } catch (FileNotFoundException e) {
            System.out.println("main метод хочет, чтобы все ошибки были обработаны");
        }
    }

    public static void readFile() throws FileNotFoundException {
        File someFile = new File("src/some_text");
        Scanner scannedFile = new Scanner(someFile);
    }
}
