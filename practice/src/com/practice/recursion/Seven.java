package com.practice.recursion;

public class Seven {
    public static void main(String[] args) {
        int seven = 717771237;
        int t = 45568217;
        System.out.println(countSeven(seven));
        System.out.println(countSeven(t));

    }

   public static int countSeven(int number) {
        if (number == 0)
            return 0;
        if (number % 10 == 7){
            return 1 + countSeven(number/10);
       }
        return countSeven(number/10);
   }
}
