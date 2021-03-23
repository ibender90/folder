package com.practice.streams;

public class Employee {
    private String firstName;
    private String secondName;
    private int salary;
    private int id;

    public Employee(int id, String firstName, String secondName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }
}
