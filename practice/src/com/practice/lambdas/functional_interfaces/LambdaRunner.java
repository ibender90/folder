package com.practice.lambdas.functional_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaRunner {
    public static void main(String[] args) {
        List<Employee> workers = new ArrayList<>();
        workers.add(new Employee("Mickel", "Smith", 2000));
        workers.add(new Employee("Jim", "Berton", 1800));
        workers.add(new Employee("Angela", "Merkel", 1500));
        workers.add(new Employee("Jack", "Nickelson", 1500));
        workers.add(new Employee("Obama", "White", 1900));

        List<Person> people = new ArrayList<>();
        people.add(new Person("Artjom", "Stalev", 31));
        people.add(new Person("Anton", "Kalinin", 30));
        people.add(new Person("Ptichka", "Greencheek", 3));
        people.add(new Person("Gorchica", "Greencheeck", 2));
        people.add(new Person("John", "Black", 40));

        System.out.println(findMatch(workers, x -> x.getSalary() > 1500)); //Predicate
        System.out.println(calcSum(workers, x -> x.getSalary())); //Function with lambda
        System.out.println(calcSum(workers, Employee::getSalary)); //Function with methode reference
        System.out.println(calcSum(people, Person::getAge));


    }

    private static <T> T findMatch(List<T> list, Predicate<T> predicateFunction) {
        for (T element : list) {
            if (predicateFunction.test(element)) {
                return element;
            }
        }
        return null;
    }

    private static <T> Integer calcSum(List<T> list, Function<T, Integer> function) {
        int sum = 0;
        for (T element : list) {
            sum += function.apply(element);
        }
        return sum;
    }
}
