package com.practice.third;

import java.util.Scanner;

public class ThirdTaskMath {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

//        while (true) {
//            System.out.println("a number to divide: ");
//            double a = scanner.nextDouble();
//            System.out.println("a divider: ");
//            double b = scanner.nextDouble();
//            if (b == 0) {
//                System.out.println("can not divide by 0");
//                break;
//            }
//            double result = a / b;
//            System.out.println("result: " + result);
//        }
        while (true) {
            System.out.println("enter number `space` and second number");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            if (b == 0) {
                System.out.println("dont divide by 0");
                break;
            }
            System.out.println("result is " + a / b);
        }
    }
}

