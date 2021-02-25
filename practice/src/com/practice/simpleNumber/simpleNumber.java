package com.practice.simpleNumber;

import java.util.Scanner;

public class simpleNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введите число");
        int someNumber = scanner.nextInt();
        int counter = 0;

        if (someNumber == 1) {
            System.out.println("число не является простым");
        } else {
            for (int i = 1; i <= someNumber; i++) {
                if (someNumber % i == 0) {
                    counter++;
                    if (counter == 3) {
                        System.out.println("число не является простым");
                        break;
                    }
                }
                if (i == someNumber) {
                    System.out.println("это простое число");
                }
            }
        }
        scanner.close();
    }
}
