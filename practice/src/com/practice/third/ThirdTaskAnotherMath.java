package com.practice.third;

import java.util.Scanner;

public class ThirdTaskAnotherMath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < 5; i++){   /// alternative while counter < 5 counter ++
            System.out.println("enter two numbers divided by space ");
            double a = scanner.nextDouble();
            double b = scanner.nextDouble();
            if (b == 0){
                System.out.println("division by zero");
                continue;}
            System.out.println("a/b = "+a/b);
        }
    }
}
