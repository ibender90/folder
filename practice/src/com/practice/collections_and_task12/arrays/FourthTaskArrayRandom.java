package com.practice.collections_and_task12.arrays;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class FourthTaskArrayRandom {
    public static void main(String[] args) {
        Scanner size = new Scanner(System.in);
        Random rm = new Random();
        System.out.println("enter array size");
        int i = size.nextInt();
        int[] myArray = new int[i];
        for (int a = 0; a < i; a++) {
            myArray[a] = rm.nextInt(10);
        }
        int counter1 = 0; //check how many numbers > 8
        int counter2 = 0; //check how many numbers = 1
        int counter3 = 0; //check how many even numbers
        int sum = 0; // sum of all numbers
        for (int element : myArray) {
            sum += element;
            if (element > 8)
                counter1++;
            else if (element == 1)
                counter2++;
            else if (element % 2 == 0)
                counter3++;
        }
        int counter4 = i - counter3;

        System.out.println("Entered number: " + i + ", following array generated");
        System.out.println(Arrays.toString(myArray));
        System.out.println("Amount of numbers > 8: " + counter1);
        System.out.println("Amount of numbers = 1: " + counter2);
        System.out.println("Amount of chetkie numbers: " + counter3);
        System.out.println("sum of all numbers is: " + sum);
        System.out.println("Amount of NEchetkie numbers: " + counter4);
        System.out.println("Array length: " + myArray.length);


    }
}
