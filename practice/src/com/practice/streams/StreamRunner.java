package com.practice.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamRunner {
    private static List<Employee> employees = new ArrayList<>();
    private static Map<Integer, Employee> employeeMap = null;

    public static void main(String[] args) throws IOException {
        employees.add(new Employee(1, "John", "Iron", 800));
        employees.add(new Employee(2, "Mike", "Brass", 700));
        employees.add(new Employee(4, "Steward", "Copper", 1000));
        employees.add(new Employee(7, "Andrew", "Silver", 600));
     //   employees.add(new Employee(7, "Andrew", "Silver", 600));  error
        employees.add(new Employee(12, "Richard", "Gold", 1200));
        employees.add(new Employee(15, "Elizabeth", "Tin", 900));

        //testStreamFromList();
        teastStreamFromFile();

    }
    private static void testStreamFromList(){
//        employees.stream()
//                .filter(e->e.getSalary() > 700)
//                .filter(e->e.getId() < 7)
//                .collect(Collectors.toList())
//                .forEach(System.out::println);

        Integer[] ids = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17};

        Stream.of(ids).map(StreamRunner::findById)
                .filter(Objects::nonNull)
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    private static void teastStreamFromFile() throws IOException {
        Files.lines(Paths.get("journal.txt"))
                .filter(e->e.contains("math"))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);
    }

    private static Employee findById(int id){
        if(employeeMap == null){
            employeeMap = employees.stream().distinct().collect(Collectors.toMap(Employee::getId, e->e));
                    //                                                              объект будет значением мап
        }
        return employeeMap.get(id);
    }
}
