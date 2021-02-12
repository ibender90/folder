package com.practice.get_set_class_as_parameter;

public class Car {
    private int yearOfBuild = 0;
    private String color = "";
    private String model = "";


    public int yearDifference(int inputYear) {
        return inputYear - yearOfBuild;
    }

    public void info() {
        System.out.println("its a car");
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
