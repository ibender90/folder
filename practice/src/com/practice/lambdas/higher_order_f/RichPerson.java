package com.practice.lambdas.higher_order_f;

public class RichPerson {
    private String firstName;
    private String secondName;
    private int age;
    private int salary;

    public RichPerson(String firstName, String secondName, int age, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + " salary " +salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
