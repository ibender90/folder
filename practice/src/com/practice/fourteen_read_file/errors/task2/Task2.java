package com.practice.fourteen_read_file.errors.task2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2. Создать в папке проекта файл people.txt в котором хранятся имена и возраст
//        людей. Реализовать статический метод
//        List<String> parseFileToStringList() , который считывает содержимое этого
//        файла и возвращает список, состоящий из значений имен и возрастов каждого
//        человека. Получить данный список в методе main() и распечатать его в консоль.
//        В случае, если файла не существует в папке проекта, в программе необходимо
//        выбрасывать исключение и выводить в консоль сообщение “Файл не найден”. Помимо
//        этого, если значение возраста отрицательно, необходимо выбрасывать исключение и
//        выводить в консоль сообщение “Некорректный входной файл”.
public class Task2 {
    public static void main(String[] args) {
        File f = new File("src/com/practice/fourteen_read_file/errors/task2/people");
        System.out.println(parseFileToStringList(f));


    }

    public static List<String> parseFileToStringList(File file) {
        File someFile = new File(String.valueOf(file));
        List<String> people = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(someFile);
            String scannedLine, name;
            String[] lineValue;
            int age;
            while (scanner.hasNextLine()) {
                scannedLine = scanner.nextLine();
                lineValue = scannedLine.split(" ");
                name = lineValue[0];
                age = Integer.parseInt(lineValue[1]);
                if (age <= 0) throw new IOException();
                people.add("Person: " + name + ", age: " + age);
            }
            return people;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Incorrect input file");
            people.clear();
        }
        return null;
    }
}
