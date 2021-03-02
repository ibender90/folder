package com.practice.generics;

public class GenericMethode {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5}; // generic не должен быть примитивным типом
        String[] stringArray = {"abc","def","ghi"};
        Double[] doubleArray = {1.23, 4.56, 7.89};

        printArray(intArray);
        printArray(stringArray);
        printArray(doubleArray);

        System.out.println("Maximum value of given array is "+getMaxValue(intArray));
        System.out.println("Maximum value of given array is "+getMaxValue(stringArray));
        System.out.println("Maximum value of given array is "+getMaxValue(doubleArray));
    }

    private static <T extends Comparable<T>> T getMaxValue(T[] array) {
        //                                     тип возвращаемого значения будет зависеть от типа данных переданных методу
        T max = array[0];
        for(T element: array){
            if(element.compareTo(max) > 0){
                max = element;
            }
        } return max;
    }

    private static <T> void printArray(T[] array) {
        System.out.println("generic methode called");
        for (T element: array){
            System.out.println(element);
        }
    }
}
