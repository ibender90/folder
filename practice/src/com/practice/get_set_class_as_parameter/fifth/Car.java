package com.practice.get_set_class_as_parameter.fifth;

public class Car {
    private int yearOfBuild = 0;
    private String color = "";
    private String model = "";

    public int howOld() {
        int old = 2021 - yearOfBuild;
        return old;
    }

    public void defineCar() {
        System.out.println("This car is " + model + " build in " + yearOfBuild + " and has a beautiful " + color + " color.");
    }

    public int getYearOfBuild() {
        return yearOfBuild;
    }


    public void setYearOfBuild(int yearOfBuild) {
        if (yearOfBuild < 1800 || yearOfBuild > 2021) {
            System.out.println("Incorrect year of build");
        } else {
            this.yearOfBuild = yearOfBuild;
        }
    }

    public String getcolor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
