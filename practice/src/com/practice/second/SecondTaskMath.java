package com.practice.second;

import java.util.Scanner;

import static java.lang.Math.pow;

public class SecondTaskMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int floors = scanner.nextInt();
//
//        if (floors >= 1 && floors <= 4) {
//            System.out.println("Малоэтажный дом");
//        } else if (floors > 4 && floors <= 8) {
//            System.out.println("Среднеэтажный дом");
//        } else if (floors > 8) {
//            System.out.println("Высотный дом");
//        } else if (floors <= 0) {
//            System.out.println("Ошибка ввода");
//        }
//
//        System.out.println("enter first number ");
//        int a = scanner.nextInt();
//
//        System.out.println("enter second number ");
//        int b = scanner.nextInt();
//
//        for(int i = a + 1; i < b; i++){
//            int ostatokDelenijaNa5 = i % 5;
//            int ostatokDelenijaNa10 = i % 10;
//            if (ostatokDelenijaNa5 == 0 && ostatokDelenijaNa10 != 0){
//                System.out.println(i);
//            }
//        }
//        int number = a + 1;
//        while (number != b) {
//            int ostatokDelenijaNa5 = number % 5;
//            int ostatokDelenijaNa10 = number % 10;
//            if (ostatokDelenijaNa5 == 0 && ostatokDelenijaNa10 != 0) {
//                System.out.println(number);
//            }
//            number++;
//        }

        System.out.println("enter x ");
        double x = scanner.nextDouble();
        double y;
        if (x >= 5) {
            y = (pow(x, 2) - 10) / (x + 7);
        }
        else if (x > -3 && x < 5) {
            y = (x + 3) * (pow(x, 2) - 2);
        }
        else y = 420;
        System.out.println("y= "+y);

    }

}
