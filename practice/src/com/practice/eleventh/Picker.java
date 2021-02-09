package com.practice.eleventh;

public class Picker implements Worker{
    private int salary;
    private Warehouse warehouse;

    public Picker(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public void doWork() {
        warehouse.setCountOrder(warehouse.getCountOrder()+1);
        salary += 80;
    }

    @Override
    public String toString() {
        return "Picker{" +
                "salary=" + salary +
                '}';
    }

    @Override
    public void bonus() {
        if(warehouse.getCountOrder() > 1500){
            salary *= 3;
        }

    }
}
