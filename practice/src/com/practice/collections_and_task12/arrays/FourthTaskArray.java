package com.practice.collections_and_task12.arrays;
import java.util.Random; //to use random Class
import java.util.Arrays; //to use array to string methode

public class FourthTaskArray {
    public static void main(String[] args) {
        Random rm = new Random(); //new object random with name rm
        for (int i = 0; i<5; i++)
            System.out.println(rm.nextInt(11));

        System.out.println("");

        int[]array = new int[5];
        array[0] = 6;
        array[1] = 5;
        array[2] = 4;
        array[3] = 3;
        array[4] = 2;
        for(int x:array){ //for each integer x = array[0...4]
            System.out.println(x);
        }
        System.out.println(Arrays.toString(array)); //6, 5, 4, 3, 2, 1

    }
}
