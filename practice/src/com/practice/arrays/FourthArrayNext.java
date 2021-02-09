package com.practice.arrays;

import java.util.Random;
import java.util.Arrays;

//4. Создать новый массив размера 100 и заполнить его случайными числами из
//        диапазона от 0 до 10000.
//        Найти максимум среди сумм трех соседних элементов. Для найденной тройки с
//        максимальной суммой выведите значение суммы и индекс первого элемента тройки.
public class FourthArrayNext {
    public static void main(String[] args) {


        Random rm = new Random();
        int[] myArray = new int[10];

        for (int i = 0; i < myArray.length; i++)
            myArray[i] = rm.nextInt(10);

//        int sum = 0;
        int maxSum = 0;
//        int counter = 0;
        int firstOfThree = 0;
//        int i = 0;
        //my solution was working correctly
//        while (counter != myArray.length - 2) { //if array length is 10, last numbers to sum up are array[7] + array[8] + array[9] if counter == 8 exit from cycle
//            for (i = counter; i < counter + 3; i++) { ///program makes 3 cycles to sum up 3 numbers, then shifts to start from next element in the line
//                sum += myArray[i];
//            }
//            counter++; // after three numbers were summed couner becomes = 1 and program starts to sum up starting from array[1]
//            if (sum > maxSum) {
//                maxSum = sum;
//                firstOfThree = counter - 1; //after three number are summed, counter = 1, as it started from array[0] to return index [0] is necessary to make counter -1;
//            }
//            sum = 0;
//        }
        //solution from author
        for (int i = 0; i < myArray.length - 2; i++) {
            int sum = 0;
            for (int j = i; j < i + 3; j++) {             //three times
                sum += myArray[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
                firstOfThree = i;
            }
        }
        System.out.println(Arrays.toString(myArray));
        System.out.println(maxSum);
        System.out.println(firstOfThree);

        System.out.println(Arrays.toString(myArray));
    }
}
