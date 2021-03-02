package com.practice.collections_and_task12.arrays;

import java.util.Arrays;
import java.util.Random;

public class FourthArraySort {
    public static void main(String[] args) {
        Random rm = new Random();
        int[] bigArray = new int[10];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = rm.nextInt(100);
        }
        System.out.println(Arrays.toString(bigArray));
        //Arrays.sort(bigArray); will be sorted from min to max meanings
        //buble sort using while+
        boolean sorted = false;
        int temp;
        while (!sorted){
            sorted = true;
            for (int i = 0; i < bigArray.length - 1; i++){
                if (bigArray[i] > bigArray[i+1]){
                    temp = bigArray[i];
                    bigArray[i]= bigArray[i+1];
                    bigArray[i+1] = temp;
                    sorted = false;
                }
            }
        }
        System.out.println(Arrays.toString(bigArray));


    }
}
