package com.practice.lambdas.functional_interfaces;

public interface Timer {
    void process();

    static void measureTime(Timer function){
        long start = System.currentTimeMillis();
        function.process(); //сюда подставляю операцию для которой будет замерено время
        long stop = System.currentTimeMillis();
        System.out.println("time spent per action: " + (stop-start));
    }
}
