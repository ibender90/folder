package com.practice.collections_and_task12.arrays;

import java.util.Arrays;

public class ArrayFillArrayCopy {
    public static void main(String[] args) {
        int[] myArray = new int[10];
        Arrays.fill(myArray, 5); //способ заполнить весь массив элементами, например числом 5
        System.out.println(Arrays.toString(myArray));

        int[] myArray2 = {1,5,8,4,9,7,9};
        int[] myArray3 = new int[5];
        System.arraycopy(myArray2,2,myArray3,2,myArray3.length-2); //способ перенести какое-то количество элементов одного массива, в другой
        //               from      from index  to    to index     how many elements
        System.out.println(Arrays.toString(myArray3));
    }
}
