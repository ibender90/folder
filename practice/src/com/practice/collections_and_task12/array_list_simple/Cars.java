package com.practice.collections_and_task12.array_list_simple;

import java.util.ArrayList;
import java.util.List;
//1. Создать список строк, добавить в него 5 марок автомобилей, вывести список в
//        консоль. Добавить в середину еще 1 автомобиль, удалить самый первый автомобиль
//        из списка. Распечатать список.

public class Cars {
    public static void main(String[] args) {
        List<String> cars = new ArrayList<>();
        cars.add("Volvo");
        cars.add("Mazda");
        cars.add("Suzuki");
        cars.add("BMW");
        cars.add("Lada");
        System.out.println(cars);
        cars.add(3, "Subaru");
        cars.remove(0);
        System.out.println(cars);
    }
}
