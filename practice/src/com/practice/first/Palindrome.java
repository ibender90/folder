package com.practice.first;

import java.util.Scanner;

/**
 * Напишите программу которая  проверяет введенное с клавиатуры число и говорит
 * является ли данное число палиндромом.
 * Палиндром - это число которое читается одинаково и спереди назад и сзади наперед.
 * Примеры 12321, 45654, 787 и т.д.
 * <p>
 * Дополнительное условие: программа принимает только числа длинной 5 знаков.
 * В случае если было введено число длинной != 5, программа должна выполнить еще
 * одно прохождение цикла и попросить снова ввести значение с клавиатуры.
 * У данной задачи есть разные варианты решения.
 * 1) С помощью конвертации чисел в строки и обратно.
 * 2) Решение с помощью щю использования остатка от деления на 10.
 * <p>
 * Вам нужно выполнить задания двумя способами.
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = 0;
        boolean correctInput = false;
        do {
            System.out.println("please enter number: ");
            while (!scanner.hasNextInt()) {
                System.out.println("its not a number");
                scanner.next();
            }
            number = scanner.nextInt();
            if (number < 10000 || number > 99999){
                System.out.println("must be 5 digits");
            }
            else correctInput = true;
        } while (!correctInput) ;

        String palindrome = String.valueOf(number);
        if ((palindrome.charAt(0) == palindrome.charAt(4)) && ((palindrome.charAt(1) == palindrome.charAt(3)))){
            System.out.println(palindrome+ " is a palindrome!");
        } else System.out.println(palindrome+" is not a palindrome");

    }
}




