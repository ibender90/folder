package com.practice.sixth;

import com.practice.fifth.Motorcycle;

//В классах Автомобиль и Мотоцикл реализовать два метода:
//        info () - выводит в консоль строку “Это автомобиль” (или “Это мотоцикл”),
//        yearDifference () - принимает на вход число (год), и возвращает разницу между
//        переданным годом и годом выпуска транспортного средства
public class Task1 {
    public static void main(String[] args) {
        Motorcycle bike1 = new Motorcycle("ducati", 2015, "black");
        Car car1 = new Car();
        car1.setModel("Suzuki");
        car1.setColor("white");
        car1.setYearOfBuild(1990);

        bike1.info();
        car1.info();

        System.out.println(bike1.howOld(2020));
        System.out.println(Math.abs(car1.yearDifference(1800))); // Math.abs returns positive meaning (absolute)






    }
}
