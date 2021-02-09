package com.practice.sixteen_files_numbers_casting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

/*2. Реализовать программу, записывающую числа разных типов в 2 файла.
        Файл 1 должен называться “file1.txt”, а Файл 2 должен называться “file2.txt”.
        Оба файла должны находиться в корне проекта. Создаваться файлы должны не
        вручную, а при запуске программы.
        Файл 1 должен содержать 1000 случайных чисел от 0 до 100.
        Файл 2 создается на основании Файла 1, но содержит числа вещественного типа
        данных.
        Метод заполнения Файла 2 следующий: для каждой группы из 20 целых чисел из
        Файла 1 рассчитывается их среднее арифметическое. Затем, полученное значение
        записывается в Файл 2. Таким образом в Файле 2 будет находиться 50 вещественных
        чисел (1000 / 20 = 50).
        После того, как Файл 2 будет сформирован, необходимо реализовать статический
        метод printResult(File file) . Этот метод должен рассчитать сумму всех
        вещественных чисел из Файла 2 и вывести её в консоль, отбросив вещественную
        часть.*/
public class Task2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file1 = new File("File1.txt");
        PrintWriter wr1 = new PrintWriter(file1);
        Random random = new Random();
        for (int i = 0; i < 1000; i++){
            wr1.println(random.nextInt(100)); // заполняю каждую строку файла числами
        }
        wr1.close();

        File file2 = new File("File2.txt");
        PrintWriter output = new PrintWriter(file2); // создаю второй файл

        Scanner scanner = new Scanner(file1); // подаю сканеру на вход объект класса FIle file1
        int counter = 0;
        int sum = 0;
        while (scanner.hasNextLine()){
            sum += Integer.parseInt(scanner.nextLine());
            counter++;
            if (counter == 20){
                output.println(sum / 20.0); // деление целого числа на вещественное даёт вещественное число
                sum = 0;
                counter = 0;
            }
        }
        scanner.close();
        output.close();
        printResult(file2);
    }
    public static void printResult (File file) throws FileNotFoundException {
        double sum = 0;
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            sum += Double.parseDouble(scanner.nextLine());
        }
        scanner.close();
        System.out.printf("%.0f%n", sum); // моё решение
        System.out.println((int)sum); //решение автора
    }
}
