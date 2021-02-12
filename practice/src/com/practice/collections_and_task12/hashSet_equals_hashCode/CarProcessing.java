package com.practice.collections_and_task12.hashSet_equals_hashCode;

import java.util.HashSet;
import java.util.Set;

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

        Set<Car> uniqueCollection = new HashSet<>(firstCollection);
        uniqueCollection.addAll(secondCollection);     //1
        //printer(uniqueCollection);

//        firstCollection.retainAll(secondCollection);   2
//        uniqueCollection.removeAll(firstCollection);   3  действия для получения только тех элементов, которые уникальны дья обоих множеств
//        printer(uniqueCollection);

        //работа с множествами
//        firstCollection.removeAll(secondCollection); //из первого множества вычетаем второе, получаем уникальные элементы первого множества
 //       printer(firstCollection);

//        secondCollection.retainAll(firstCollection); // пересечение множеств, выдаст только одинаковые элементы
 //       printer(secondCollection);





    }

    private static void printer(Set<Car> cars) {
        System.out.printf("%-10s %-10s %-10s\n", "Car brand", "model", "price per day"); // размещаем каждую строку слева, выделяем 10 знаков
        for(Car car: cars){
            System.out.printf("%-10s %-10s %-10s\n", car.getBrand(), car.getModel(), car.getPricePerDay());
        }
    }
}
