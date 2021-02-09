package com.practice.fourteen_read_file.errors.read_file_throw_exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {

        File myFile = new File("src/some_text");

        try {
            Scanner scanner = new Scanner(myFile);
            System.out.println("эта строка уже не будет выполнена в случае ошибки, так как она находитс в блоке try");

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден"); //переопределяем то, что будет выведено в случае ошибки
        }
        System.out.println("to be continued");

        //scanner.close();
    }
}
