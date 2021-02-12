package com.practice.collections_and_task12.stack_deck_queue_set;

import java.util.*;


public class HashSetTypes {
    public static void main(String[] args) {
        String[] cars1 = {"Lada", "Ural", "Zil", "BMW"};
        String[] cars2 = {"BMW", "Audi", "Mercedes", "Ural"};

        Set<String> carsFirst = new HashSet<>(Arrays.asList(cars1));
        Set<String> carsSecond = new HashSet<>(Arrays.asList(cars2));
        Set<String> uniqueCarCollection = new HashSet<>(carsFirst);//HashSet хранит только уникальные компоненты того типа, что задан в параметрах
        uniqueCarCollection.addAll(carsSecond); //игнорирует те машины, что уже есть
        printCars(uniqueCarCollection);

        Set<String> carsOne = new LinkedHashSet<>(Arrays.asList(cars1));
        Set<String> carsTwo = new LinkedHashSet<>(Arrays.asList(cars2));
        Set<String> properOrderUniqueCarCollection = new LinkedHashSet<>(carsOne);
        properOrderUniqueCarCollection.addAll(carsTwo); //LinkedHashset сохраняет порядок элементов как в исходном списке
        printCars(properOrderUniqueCarCollection);

        Set<String> carsUno = new TreeSet<>(Arrays.asList(cars1)); //TreeSet сортирует свои элементы
        Set<String> carsDos = new TreeSet<>(Arrays.asList(cars2));
        Set<String> sortedUniqueCarCollection = new TreeSet<>(carsUno);
        sortedUniqueCarCollection.addAll(carsDos);
        printCars(sortedUniqueCarCollection);

    }
    private static void printCars(Set<String> collection){
        System.out.println(collection);
    }
}
