package com.practice.fourteen_read_file.errors.read_file_throw_exception;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/*1. Создать .txt файл в папке проекта, как показано в видео (урок 36, время 15:30).
        Заполнить его вручную десятью произвольными числами. Реализовать статический
        метод printSumDigits(File file) , который считает сумму всех чисел в этом
        файле и выводит ее на экран. Вызвать данный метод в методе main().
        Если файла не существует в папке проекта, в программе необходимо выбрасывать
        исключение и выводить в консоль сообщение “Файл не найден”. Помимо этого, если
        чисел в файле меньше или больше 10, необходимо выбрасывать исключение и
        выводить в консоль сообщение “Некорректный входной файл”.*/
public class Task1 {
    public static void main(String[] args) {
        File file = new File("src/some_text");
        printSumDigits(file);
    }

    public static void printSumDigits(File file) {
        File f = new File(String.valueOf(file));
        try {
            Scanner scanner = new Scanner(f);
            String scannedLine = scanner.nextLine();
            String[] numbers = scannedLine.split(" ");
            if (numbers.length != 10) throw new IOException();
            int sum = 0;
            for (String element : numbers) {
                sum += Integer.parseInt(element);
            }
            System.out.println(sum);
        } catch (FileNotFoundException e) {
            System.out.println("where is my file");
        } catch (IOException e) {
            System.out.println("Incorrect input file");
        }




    }
}
