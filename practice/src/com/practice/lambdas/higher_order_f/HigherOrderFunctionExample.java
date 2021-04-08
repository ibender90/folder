package com.practice.lambdas.higher_order_f;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HigherOrderFunctionExample {
    public static void main(String[] args) {
        List<RichPerson> richPeople = new ArrayList<>();
        richPeople.add(new RichPerson("Jack", "Black", 45, 7000));
        richPeople.add(new RichPerson("Nickolas", "Cage", 51, 5000));
        richPeople.add(new RichPerson("Leonardo", "Dcaprio", 49, 9000));
        richPeople.add(new RichPerson("Scarlet", "Johanson", 37, 8000));
        testPredicate(richPeople);
        testFunction(richPeople);
        testConsumer(richPeople);
    }

    private static void testPredicate(List<RichPerson> richPersonList) {
        System.out.println("Testing predicate");
        Predicate<RichPerson> isRich = x -> x.getSalary() >= 7000;
        Predicate<RichPerson> isYoung = x -> x.getAge() < 46;
        System.out.println("Someone who are rich and young: ");
        findAll(richPersonList, isRich.and(isYoung)).forEach(System.out::println);
        System.out.println("Not young anymore: ");
        findAll(richPersonList, isYoung.negate()).forEach(System.out::println);
    }

    private static <T> List<T> findAll(List<T> list, Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                filteredList.add(element);
            }
        }
        return filteredList;
    }

    private static void testFunction(List<RichPerson> people) {
        System.out.println("Testing function");
        Function<RichPerson, String> combineNameAndSurname = x -> x.getFirstName() + " " + x.getSecondName();
        Function<String, String> sayHello = y -> "Hello " + y;

        Function<RichPerson, String> composedFunction = sayHello.compose(combineNameAndSurname);
        transform(people, composedFunction).forEach(System.out::println);

        System.out.println("Composing functions");
        List<String> transformedList = transform(people, composedFunction);
        Function<String, String> toUpper = String::toUpperCase;
        Function<String, String> exclaim = z -> z + " !!!";

        transform(transformedList, compose(toUpper, exclaim)).forEach(System.out::println);

    }

    private static <T> Function<T, T> compose(Function<T, T>... functions) {
        Function<T, T> result = Function.identity();
        for (Function<T, T> f : functions) {
            result = result.andThen(f);
            //сначала выполняю первую функцию переданную в метод, затем остальные
        }
        return result;
    }

    private static <T, R> List<R> transform(List<T> elements, Function<T, R> function) {
        // transform возвращает новый список на каждом элементе которого была применена абстрактная функция
        List<R> list = new ArrayList<>();
        for (T e : elements) {
            list.add(function.apply(e));
        }
        return list;
    }

    private static void testConsumer(List<RichPerson> list) {
        Consumer<RichPerson> rise = x -> x.setSalary(x.getSalary() * 11 / 10);
        processList(list, rise.andThen(System.out::println));

    }

    private static <T> void processList(List<T> elements, Consumer<T> consumer){
        for (T e: elements){
            consumer.accept(e);
        }
    }

}
