package com.practice.get_set_class_as_parameter;

public class Airplane {

    private String producer;
    private int yearBuilt;
    private int length;
    private int fuel;
    private int weight;

    public Airplane(String producer, int yearBuilt, int length, int weight){
        this.length = length;
        this.yearBuilt = yearBuilt;
        this.producer = producer;
        this.weight = weight;
        this.fuel = 0;
    }

    public void info() {
        System.out.println("Producer: " + producer + " , year of build: " +yearBuilt + " , length: " + length + " , weight: " + weight + " kg, fuel left: " + fuel + " L.");
    }

    public int fillUp(int fuel){
        return this.fuel += fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setYearBuilt(int yearBuilt){
        this.yearBuilt = yearBuilt;
    }
    public void setLength(int length){
        this.length = length;
    }

}
