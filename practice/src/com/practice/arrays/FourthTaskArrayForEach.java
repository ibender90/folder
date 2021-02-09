package com.practice.arrays;

import java.util.Random;
import java.util.Arrays;

//2. Создать новый массив размера 100 и заполнить его случайными числами из
//        диапазона от 0 до 10000.
//        Затем, используя циклы for each вывести:
//        - наибольший элемент массива
//        - наименьший элемент массива
//        - количество элементов массива, оканчивающихся на 0
//        - сумму элементов массива, оканчивающихся на 0
//        Использовать сортировку запрещено.
public class FourthTaskArrayForEach {
    public static void main(String[] args) {
        Random rm = new Random();
        int[] bigArray = new int[10];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = rm.nextInt(100);
        }
        System.out.println(Arrays.toString(bigArray));

//        int bigNumber = 0;                        // sorting array using for and if
//        for(int i = 0; i <100; i++){
//            if (bigArray[i] > bigNumber){
//                bigNumber = bigArray[i];
//            }
//        }
//        System.out.println(bigNumber);

        int bigNumber = 0;
        for (int element : bigArray) {
            if (element > bigNumber) {
                bigNumber = element;
            }
        }
        System.out.println("biggest number of array is: "+bigNumber);

        int smallNumber = 100;
        for (int element : bigArray) {
            if (element < smallNumber) {
                smallNumber = element;
                //System.out.println("new smallest is:"+smallNumber);}
            }
        }
        System.out.println("smallest number of array is: "+smallNumber);

        int roundNumber = 0;
        int sumOfRoundNumbers = 0;
        for (int element : bigArray) {
            if (element % 10 == 0) {
                sumOfRoundNumbers += element;
                roundNumber++;
            }
        }
        System.out.println("amount of numbers which have 0 in the end: " + roundNumber);
        System.out.println("sum of numbers which have 0 in the end: " + sumOfRoundNumbers);


    }
}
