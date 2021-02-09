package com.practice.fourteen_read_file.errors.task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*3. Создать класс “Человек” с полями “имя” и “возраст”. Реализовать статический метод
        List<Person> parseFileToObjList() , который считывает содержимое того же
        файла people.txt , создает экземпляры класса “Человек” и возвращает список
        объектов. Получить данный список в методе main() и распечатать его в консоль.*/
public class Task3 {
    public static void main(String[] args) {
        File f = new File("src/com/practice/fourteen_read_file/errors/task2/people");
        System.out.println(parseFileToStringList(f));

    }

    public static List<People> parseFileToStringList(File file) {
        File someFile = new File(String.valueOf(file));
        List<People> people = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(someFile);
            String scannedLine;
            String[] lineValue;
            while (scanner.hasNextLine()) {
                People person = new People();
                scannedLine = scanner.nextLine();
                lineValue = scannedLine.split(" ");
                person.setName(lineValue[0]);
                person.setAge(Integer.parseInt(lineValue[1]));
                if (person.getAge() <= 0) throw new IOException();
                people.add(person);
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
