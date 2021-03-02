package com.practice.get_set_class_as_parameter.fifth;

//2. Создать класс Мотоцикл (англ. Motorbike ), с полями “Год выпуска”, “Цвет”,
//        “Модель”. Создать экземпляр класса Мотоцикл, с помощью конструктора (сеттеры не
//        использовать). Придерживаться принципов инкапсуляции и использовать ключевое
//        слово this . Геттером получить год выпуска, цвет, модель, вывести значения в
//        консоль.
public class Motorcycle {

    private String model;
//    private int age;
    private String color;
    private int yearBuild;

    public Motorcycle(String model, int yearBuild, String color) {
        this.color = color;
        this.yearBuild = yearBuild;
        this.model = model;
    }



    public void info(){
        System.out.println("its a motorcycle");
    }

    public int howOld(int inputYear){
        return inputYear - yearBuild;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }
}
