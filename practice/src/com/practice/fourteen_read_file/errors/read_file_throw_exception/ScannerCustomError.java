package com.practice.fourteen_read_file.errors.read_file_throw_exception;

import java.util.Scanner;

public class ScannerCustomError {
    public static void main(String[] args) throws ScannerError {
        Scanner scanner = new Scanner(System.in);
        while (true) { //endless cycle
            System.out.println("enter some number");
            int x = Integer.parseInt(scanner.nextLine()); // преобразовываем считанные строки в целые числа
            if (x != 0){
                    throw new ScannerError("zero was expected");
            }
        }
    }
}
