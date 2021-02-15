package com.practice.collections_and_task12.tree_set;

import java.util.*;

public class CarProcessing {
    public static void main(String[] args) {
        Set<Car> firstCollection = new HashSet<>();
        firstCollection.add(new Car("BMW", "120D", 15));
        firstCollection.add(new Car("Toyota", "Corolla", 10));
        firstCollection.add(new Car("Volvo", "XC90", 40));
        firstCollection.add(new Car("Suzuki", "Swift", 6));

        Set<Car> secondCollection = new HashSet<>();
        secondCollection.add(new Car("Subaru", "Forester", 30));
        secondCollection.add(new Car("Audi", "100", 10));
        secondCollection.add(new Car("Toyota", "Corolla", 10));
        secondCollection.add(new Car("Volvo", "XC90", 40));

        NavigableSet<Car> uniqueCollection = new TreeSet<>(firstCollection); //сохраняю коллекцию машин в дерево Navigable даёт доступ к методам работы с деревом
        uniqueCollection.addAll(secondCollection);
        //printer(uniqueCollection);

        SortedSet<Car> under = uniqueCollection.headSet(new Car("BMW", "120D", 15)); //выводит те элементы, которые ниже этого узла в дереве
        //printer(under);

        SortedSet<Car> above = uniqueCollection.tailSet(new Car("BMW", "120D", 15));
        //printer(above); //tailSet включает переданный элемент и те, что расположены над ним

        SortedSet<Car> inBetween = uniqueCollection.subSet(new Car("BMW", "120D", 15), true,
                new Car("Volvo", "XC90", 40), true);

        //printer(inBetween); // создал набор элементов в промежутке между указаных и с помощью true их тоже включил в коллекцию

        //System.out.println(uniqueCollection.higher(new Car("BMW", "120D", 15)));
        //.higher возвращает объект стоящий выше в дереве чем заданый как параметр, поскольку сейчас сортировка по цене по убыванию, те машины, что дороже находятся в дереве выше.

        System.out.println(uniqueCollection.ceiling(new Car("Subaru", "Forester", 31)));
        //ceiling выведет тот элемент что передан если он есть либо тот, что стоит выше

        System.out.println(uniqueCollection.floor(new Car("Subaru", "Forester", 29)));
        //floor выведет тот элемент что передан если он есть либо тот, что стоит ниже


    }

    private static void printer(Set<Car> cars) {
        System.out.printf("%-10s %-10s %-10s\n", "Car brand", "model", "price per day"); // размещаем каждую строку слева, выделяем 10 знаков
        for(Car car: cars){
            System.out.printf("%-10s %-10s %-10s\n", car.getBrand(), car.getModel(), car.getPricePerDay());
        }
    }
}
