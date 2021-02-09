package com.practice.fourteen_read_file.errors.read_file_throw_exception;

import java.io.IOException;
import java.util.Scanner;

public class numberScanner { //исключение обработано через стандартный клас IOException
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (true) { //endless cycle
            int x = Integer.parseInt(scanner.nextLine()); // преобразовываем считанные строки в целые числа
            if (x != 0){
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("ты ввёл не 0");
                }
            }
        }
    }
}
