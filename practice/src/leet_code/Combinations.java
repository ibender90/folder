package leet_code;

import java.util.Arrays;

public class Combinations {
        private static final int M = 3;
        private static final int N = 5;

        private static int[] generateCombinations(int[] arr)
        {
            if (arr == null)
            {
                arr = new int[M];
                for (int i = 0; i < M; i++)
                    arr[i] = i + 1;
                return arr;
            }
            for (int i = M - 1; i >= 0; i--)
                if (arr[i] < N - M + i + 1)
                {
                    arr[i]++;
                    for (int j = i; j < M - 1; j++)
                        arr[j + 1] = arr[j] + 1;
                    return arr;
                }
            return null;
        }
        public static void main(String args[])
        {
            int[] arr = null;
            while ((arr = generateCombinations(arr)) != null)
                System.out.println(Arrays.toString(arr));
        }
    }

