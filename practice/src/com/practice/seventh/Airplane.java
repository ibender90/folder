package com.practice.seventh;

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

    public static void compareAirplanes(Airplane a1, Airplane a2){
        if(a1.getLength() > a2.getLength()){
            System.out.println(a1.getProducer()+" длинне чем "+a2.getProducer());
        } else if(a1.getLength() < a2.getLength()){
            System.out.println(a2.getProducer()+" длинне чем "+a1.getProducer());}
        else System.out.println("Самолёты равной длины");
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

    public int getLength(){
        return length;
    }
    public String getProducer(){
        return producer;
    }

}
