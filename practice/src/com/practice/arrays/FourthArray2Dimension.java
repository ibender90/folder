package com.practice.arrays;

import java.util.Random;

//Заполнить двумерный массив (матрицу) случайными числами от 0 до 50. Размер
//        матрицы задать m=12 , n=8 ( m - размерность по строкам, n - размерность по колонкам).
//        В консоль вывести индекс строки, сумма чисел в которой максимальна. Если таких
//        строк несколько, вывести индекс последней из них.
//        Пример сгенерированной матрицы (для простоты m=3 , n=5 ):
//        3 2 1 5 7 // сумма - 18
//        1 2 5 6 2 // сумма - 16
//        3 4 9 6 4 // сумма - 26
//        Ответ: 2 (индекс строки, сумма чисел в которой максимальна)
public class FourthArray2Dimension {
    public static void main(String[] args) {
        int[][] tableArray = new int[12][8];
        Random rm = new Random();
        for (int i = 0; i < tableArray.length; i++) {
            for (int j = 0; j < tableArray[i].length; j++) {
                tableArray[i][j] = rm.nextInt(50);
                System.out.print(tableArray[i][j] + "\t");
            }
            System.out.println();
        }
        int maxSum = 0;
        int lineInx = 0;
        for (int i = 0; i < tableArray.length; i++) {
            int sum = 0; //after j reaches maximum sum becomes zero to begin next line calculation
            for (int j = 0; j < tableArray[i].length; j++) {
                sum += tableArray[i][j];
            }
            if(sum >= maxSum){ //compare every result with last one even if the same, we need index of last biggest and it will be updated
                maxSum = sum;
                lineInx = i;
            }
        }

        System.out.println("biggest sum in the line: " + maxSum);
        System.out.println("line index of biggest sum: " + lineInx);

    }
}
