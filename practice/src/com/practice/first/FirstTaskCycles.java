package com.practice.first;

public class FirstTaskCycles {
    public static void main(String[] args) {
        int counter = 0;
        String expression = "JAVA";

        System.out.println("while cycle:");
        while (counter != 10) {
            System.out.print(expression + " ");
            counter++;
        }
        System.out.println("\nfor cycle:");
        for (int i = 0; i < 10; i++) {
            System.out.print(expression + " ");
        }

        System.out.println("\n");
        int year = 1980;
        while (year <= 2020) {
            System.out.println("Olympics of " + year);
            year = year + 4;
        }
        for (int olYear = 1980; olYear <= 2020; olYear = olYear + 4) {
            System.out.println("Olympics of " + olYear);
        }
//        int k = 5;
//        for (int a = 1; a < 10; a++) {
//            int result = a * k;
//            System.out.println(a + "*" + k + "=" + result);
//        }
      }
    }
