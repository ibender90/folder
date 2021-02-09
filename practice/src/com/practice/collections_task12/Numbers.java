package com.practice.collections_task12;

import java.util.ArrayList;
import java.util.List;

//2. Создать новый список, заполнить его четными числами от 0 до 30 и от 300 до 350.
//        Вывести список.
public class Numbers {
    public static void main(String[] args) {
        List<Integer> even = new ArrayList<>();
        for(int i = 0; i <= 30; i+=2){
            even.add(i);
        }
        for (int i = 300; i <= 350; i+=2){
            even.add(i);
        }
        System.out.println(even);
    }
}
