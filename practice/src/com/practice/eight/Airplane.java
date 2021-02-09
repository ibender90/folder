package com.practice.eight;

//Скопируйте класс Самолет из задания дня 6.
//        Внесите изменения в класс таким образом, чтобы следующий код выводил
//        информацию о самолете, аналогично вызову метода info() .
//        Airplane airplane = new Airplane ( "Boeing" , 2000 , 150 , 10000 );
//        System. out . println (airplane);
public class Airplane {

    private String producer;
    private int yearBuilt;
    private int length;
    private int fuel;
    private int weight;

    public Airplane(String producer, int yearBuilt, int length, int weight) {
        this.length = length;
        this.yearBuilt = yearBuilt;
        this.producer = producer;
        this.weight = weight;
        this.fuel = 0;
    }

    public void info() {
        System.out.println("Producer: " + producer + ", year of build: " + yearBuilt + ", length: " + length + ", weight: " + weight + " kg, fuel left: " + fuel + " L.");
    }

    public int fillUp(int fuel) {
        return this.fuel += fuel;
    }

    public int getFuel() {
        return fuel;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    @Override
    public String toString() {
        return
                "Producer: " + producer +
                        ", year of built: " + yearBuilt +
                        ", length: " + length +
                        ", weight: " + weight +
                        " kg, fuel left: " + fuel +
                        " L.";


    }

    public void setLength(int length) {
        this.length = length;
    }

}
