package com.practice.complex_wordcounter;

import java.util.*;

public class EveryWordCounter {
    public static void everyWord(Scanner scanner){
        Map<String,Integer> simpleMap = new HashMap<>(); //декларирую мап, где ключом будет строка, а значением число
        while (scanner.hasNextLine()){
        String line = scanner.nextLine();
        String[] words = line.split(" "); //сначала сохраняю в строку данные из сканера
        for(String word: words){
            if (!BasicWordCounter.isNumber(word) && !BasicWordCounter.isSign(word)) {
                String key = word.toLowerCase();
                Integer counter = simpleMap.get(key); //спрашиваю каждый раз, есть ли такая пара в мапе
                if (counter == null) {
                    simpleMap.put(key, 1); //если не получаю значения по этому ключу, записываю единицу
                } else
                    simpleMap.put(key, counter + 1); // если получаю какое-то число, увеличиваю его на 1 и перезаписываю пару
            }
        }}
        simplePrint(simpleMap);
    }
    private static void simplePrint(Map<String, Integer> map) {
        Map<String,Integer> wordsAsTreeMap = new TreeMap<>(map); //создаю мап в виде дерева и передаю туда мап с полученными из сканера парами для сортировки (в случае с ключом типа String сортировка будет по алфавиту)
        Set<String> keys = wordsAsTreeMap.keySet(); // записываю в сет все ключи
        for(String key: keys){
            System.out.printf("%-15s%-10s \n", key, map.get(key)); // вывожу набор из ключа и значения для этого ключа
        }
    }
}
