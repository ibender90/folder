package com.practice.lambdas;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface MyFirstFuctionalInterface{
    double process(int element);
    // абстрактный метод принимает целое число, возвращает число с дробной частью
}
@FunctionalInterface
interface MyInterfaceWithGererics<T extends Number> {
    double process(T element);
    // T  = тип который наследуется от Number, например Integer, Double, Float, Long
}

public class LambdaAndFunctionalnterface {
    public static void main(String[] args) {
        List<Integer> intlist = new ArrayList<>();
        intlist.add(1);
        intlist.add(2);
        intlist.add(3);
        intlist.add(4);
        intlist.add(5);
        intlist.add(6);

        List<Double> dList = new ArrayList<>();
        dList.add(1.1);
        dList.add(1.2);
        dList.add(1.3);
        dList.add(1.4);
        dList.add(1.5);
        dList.add(1.6);

        simpleProcessing(intlist, x -> Math.sqrt(x));
        //                       x = то целое число, которое принимает метод в интерйфейсе, взято каждое из списка intList

        processWithGenerics(dList, x-> Math.pow(x.doubleValue(), 2));

    }

    private static void simpleProcessing(List<Integer> list, MyFirstFuctionalInterface processor){
        for(Integer i : list){
            System.out.println(processor.process(i));
            // каждый элемент из списка будет передан в метод интерфейса, который реализован в лямбда выражении
        }
    }

    private static <T extends Number> void processWithGenerics(List<T> list, MyInterfaceWithGererics processor){
        for(Number i : list) {
            System.out.println(processor.process(i));
        }
    }


}
