package leet_code;

import java.util.*;
import java.util.stream.Collectors;

public class Candies {
    public static void main(String[] args) {
        Random random = new Random();
        //int amountOfCandies = random.nextInt(9998) + 2;
        int amountOfCandies = 10;
        if (amountOfCandies % 2 != 0) {
            amountOfCandies--;
        }
        int[] boxOfCandies = new int[amountOfCandies];
        for (int i = 0; i < amountOfCandies; i++) {
            //boxOfCandies[i] = random.nextInt(100_000) - random.nextInt(100_000);
            boxOfCandies[i] = random.nextInt(10);
        }
        int maximumAllowedToEat = amountOfCandies / 2; // M

        System.out.println(Arrays.toString(boxOfCandies));

        Set<Integer> uniqueCandies = Arrays.stream(boxOfCandies).boxed().collect(Collectors.toSet());  // получаю множество уникальных конфет
        int amountOfUniqueCandies = uniqueCandies.size();  // N
        System.out.println(uniqueCandies);

        int[] uniqueTaste = new int[maximumAllowedToEat];
        List<int[]> tastes = new ArrayList<>();
        Iterator<Integer> giveMeCandy = uniqueCandies.iterator();

        for (int i = 0; i < maximumAllowedToEat; i++) { //создаю первый набор конфет, который буду изменять
            uniqueTaste[i] = giveMeCandy.next();
        }
        giveMeCandy = uniqueCandies.iterator();// сбрасываю итератор

        for (int i = 0; i < maximumAllowedToEat; i++) { //wrong
            while (giveMeCandy.hasNext()) {
                uniqueTaste[i] = giveMeCandy.next();
                tastes.add(uniqueTaste);
            }
            giveMeCandy = uniqueCandies.iterator();
        }
        printTastes(tastes);
        //System.out.println(Arrays.toString(uniqueTaste));
    }

    private static void printTastes(List<int[]> list) {
        for (int[] element : list) {
            System.out.println(Arrays.toString(element));
        }
    }
}
