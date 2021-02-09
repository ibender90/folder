package com.practice.fifteen_write_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Writer {
    public static void main(String[] args) {
        File sourceFile = new File("files/shoes.csv");
        File outputFile = new File("files/missing shoes");
        try {
            Scanner scannedFile = new Scanner(sourceFile);
            PrintWriter missingShoes = new PrintWriter(outputFile);
            while (scannedFile.hasNextLine()) {
                String[] line = scannedFile.nextLine().split(";");
                if (Integer.parseInt(line[2]) == 0) {
                    missingShoes.println(Arrays.toString(line));
                }
            } scannedFile.close(); //
            missingShoes.close(); //без закрытия потока чтения и записи программа не отрабатывает корректно
            System.out.println("should be success");
        } catch (FileNotFoundException e){
            System.out.println("source file is missing");
        }
    }
}
