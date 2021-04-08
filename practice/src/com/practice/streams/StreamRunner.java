package com.practice.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {
    private static List<Employee> employees = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) throws IOException {
        employees.add(new Employee(1, "John", "Iron", 800, "IT"));
        employees.add(new Employee(2, "Mike", "Brass", 700, "IT"));
        employees.add(new Employee(4, "Steward", "Copper", 1000, "IT"));
        employees.add(new Employee(7, "Andrew", "Silver", 600, "Welding"));
        employees.add(new Employee(7, "Andrew", "Silver", 600, "Welding"));
        employees.add(new Employee(12, "Richard", "Gold", 1200, "Welding"));
        employees.add(new Employee(15, "Elizabeth", "Tin", 900, "Welding"));

        //testStreamFromList();
        //teastStreamFromFile();
        //testSortAndReduce();
        //partitionByIncome();
        //groupByCriterion(Employee::getDepartment);
        testStreamGenerator(5);
    }

    private static <R> void groupByCriterion(Function<Employee, R> function) {        // НЕПОНЯТНО!
        Map<R, List<Employee>> collectedByCriterion = employees.stream().collect(Collectors.groupingBy(function));
        collectedByCriterion.keySet().stream().forEach(e -> System.out.println(e + "\n" + collectedByCriterion.get(e)));
    }

    private static void testStreamFromList() {
//        employees.stream()
//                .filter(e->e.getSalary() > 700)
//                .filter(e->e.getId() < 7)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        Integer[] ids = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17};

        Stream.of(ids).map(StreamRunner::findById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void teastStreamFromFile() throws IOException {
        Files.lines(Paths.get("journal.txt"))
                .filter(e -> e.contains("math"))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);
    }

    private static Employee findById(int id) {
        if (employeeMap == null) {
            employeeMap = employees.stream().distinct().collect(Collectors.toMap(Employee::getId, e -> e));
            //                                                              объект будет значением мап
        }
        return employeeMap.get(id);
    }

    private static void testSortAndReduce() {
        System.out.println("Employee with max ID: ");
        Employee employeeWithMaxID = employees.stream()
                .max((e1, e2) -> e1.getId() - e2.getId()) //компаратор по ид чтобы найти наибольший
                .get();
        System.out.println(employeeWithMaxID);

        System.out.println("Sorting by name");

        employees.stream().sorted((s1, s2) -> s1.getFirstName().compareTo(s2.getFirstName())) // сортирую по name
                .distinct() // убираю второго andrew
                .collect(Collectors.toList()).forEach(System.out::println);

        Employee identity = new Employee(0, " ", " ", 0, " "); // хорошо использовать в reduce для избежания ошибок
        Employee iDandSalartySummedUP = employees.stream().reduce(identity, (e1, e2) -> {
            e1.setId(e1.getId() + e2.getId());
            e1.setSalary(e1.getSalary() + e2.getSalary());
            return e1;
        });
        System.out.println("summed ID: " + iDandSalartySummedUP.getId() + "\nsummed salary: " + iDandSalartySummedUP.getSalary());

    }

    private static void partitionByIncome() {
        Map<Boolean, List<Employee>> partitionedBySalary = employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() >= 900));
        // создаю мап, в котором будет два ключа true & false полученых от интерфейса предикат                       здесь
        System.out.println("Rich people: " + partitionedBySalary.get(true));
        System.out.println("Poor people: " + partitionedBySalary.get(false));
    }

     private static void testStreamGenerator(int limit){
        Stream.generate(Math::random).limit(limit).forEach(System.out::println); //bounded stream метод generate сработает переданное количество раз
     }

     private static void testStreamIterator(int limit){
        Stream.iterate(1,e->e*2).limit(limit).forEach(System.out::println); //выполняю действие над seed заданное количество раз
     }

}
