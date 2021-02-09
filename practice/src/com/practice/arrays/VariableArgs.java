package com.practice.arrays;

public class VariableArgs {
    public static void main(String[] args) {
        int[][] myArray = {{1,2,3},{3,2,1},{3,3,3},{2,2,2}};
        System.out.println(caclAverageOfSomeElements(myArray[0][0],myArray[0][1],myArray[0][2])); // (1+2+3)/3 = 2
        System.out.println(caclAverageOfSomeElements(2, 4, 8, 12)); //любое количество чисел
        System.out.println(("Smallest number in array is " +findMinimum(myArray)));

    }
    private static int caclAverageOfSomeElements(int... args){ // получаем какое-то количество целых чисел и считаем их среднее
        int sum = 0;
        for(int methodInput: args){
            sum += methodInput;
        }
        return sum/args.length;
    }
    private static int findMinimum(int[][] someArray){
        int min = 100;
        for(int[] line : someArray){
            for(int element: line){
                if (element < min){
                    min = element;
                }
            }
        }
        return min;

    }
}
