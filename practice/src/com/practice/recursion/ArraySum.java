package com.practice.recursion;
//сумма элементов массива через рекурсию

public class ArraySum {
    public static void main(String[] args) {
        int[] numbers = {1, 10, 1241, 50402, -50, 249, 10215, 665, 2295, 7, 311};
        System.out.println(recursionSum(numbers, 0));
    }

    private static int recursionSum(int[] a, int i){
        if (i == a.length)
            return 0;
        return a[i] + recursionSum(a, i+1);
    }
}
