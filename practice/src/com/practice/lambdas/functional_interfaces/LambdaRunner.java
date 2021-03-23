package com.practice.lambdas.functional_interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
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

        BinaryOperator<Integer> summator = (x1,x2) -> x1+x2; //summator = combiner
        System.out.println("sum of salaries " + testBinary(workers, 0, Employee::getSalary, summator));

        Timer.measureTime(() -> calcSum(workers, x -> x.getSalary()));  // использую интерфейс таймер

        BinaryOperator<Integer> maxFinder = Math::max;
        System.out.println("Max age "+ testBinary(people, 0, Person::getAge, maxFinder));
        System.out.println("Max salary "+ testBinary(workers, 0, Employee::getSalary, maxFinder));

        //Iterface consumer - returns void
        people.forEach(e->e.setAge(e.getAge() + 1)); //
        //            1 action, returns void
        people.forEach(System.out::println);

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

    private static <T, R> R testBinary(List<T> list, R zeroElement, Function<T, R> function,
                                        BinaryOperator<R> combiner){
        for(T element: list){
            zeroElement = combiner.apply(zeroElement, function.apply(element));
            //            combiner реализуем отдельн      получам, например, зарплату через getSalary
        }
        return zeroElement;
    }
}
