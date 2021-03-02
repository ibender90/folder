package com.practice.work_with_fields;
//1. Для этого задания скопируйте класс Самолет из предыдущего дня в пакет текущего
//        дня.
//        В классе Самолет создать статический метод compareAirplanes , который в
//        качестве аргументов принимает два объекта класса Airplane (два самолета) и выводит
//        сообщение в консоль о том, какой из самолетов длиннее.
public class Task1 {
    public static void main(String[] args) {
        Airplane plane1 = new Airplane("bmw", 1925,14,500);
        Airplane plane2 = new Airplane("Tulsk",1925,12,100);

        Airplane.compareAirplanes(plane1,plane2);
    }
}
