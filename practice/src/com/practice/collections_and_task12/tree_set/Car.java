package com.practice.collections_and_task12.tree_set;

import java.util.Objects;

public class Car implements Comparable<Car> { //использование treeSet требует уточнения как будут сравниваться объекты класса, это определяет метод compareTo из
    //интерфейса Comparable
    private final String brand;
    private final String model;
    private final Integer pricePerDay;

    public Car(String brand, String model, Integer pricePerDay) {
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getPricePerDay() {
        return pricePerDay;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // если оба объекта ссылаются на одну область пасяти
            return true;
        }
        if (obj == null | obj.getClass() != this.getClass()) { //если объект ссылается на пустоту или классы не совпадают
            return false;
        }
        Car car = (Car) obj; //создаю переменную моего типа и помещаю туда объект приведённый к этому типу
        return (this.brand.equals(car.getBrand()) && this.model.equals(car.getModel()) && this.pricePerDay.equals(car.getPricePerDay()));
    } // сравниваем поля класса

    @Override
    public int hashCode() { // имплементировать equals всегда нужно вместе с hashcode
        return Objects.hash(brand, model, pricePerDay);
    }

    @Override
    public int compareTo(Car car) {
        if(pricePerDay < car.getPricePerDay()){
            return -1;
        }
        if(pricePerDay > car.getPricePerDay()){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", pricePerDay=" + pricePerDay +
                '}';
    }
}
