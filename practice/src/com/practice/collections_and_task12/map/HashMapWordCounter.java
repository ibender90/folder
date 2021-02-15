package com.practice.collections_and_task12.map;

import java.util.*;

public class HashMapWordCounter { // программа не учитывает знаки препинания
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter text to analyse \n");
        String line = scanner.nextLine();
        String[] words = line.split(" "); //сначала сохраняю в строку данные из сканера
        Map<String,Integer> simpleMap = new HashMap<>(); //декларирую мап, где ключом будет строка, а значением число
        for(String word: words){
            String key = word.toLowerCase();
            Integer counter = simpleMap.get(key); //спрашиваю каждый раз, есть ли такая пара в мапе
            if(counter == null){
                simpleMap.put(key, 1); //если не получаю значения по этому ключу, записываю единицу
            } else simpleMap.put(key, counter+1); // если получаю какое-то число, увеличиваю его на 1 и перезаписываю пару
        }

       // simplePrint(simpleMap);
        NavigableSet<WordWrapper> sortedByValue = convertToSet(simpleMap); //sortedByValue множество элементов отсортированное в дереве по значению
        // Collections.reverse(); если нужно сортировать в обратном направлении
        //Collections.unmodifiableSet(); если хотим запретить изменять какое-то множество
        sortedPrint(sortedByValue);
    }

    private static void sortedPrint(NavigableSet<WordWrapper> sortedByValue) {
        for(WordWrapper wrappedValues : sortedByValue){ // беру каждый элемент множества и использую его toString имплементацию
            System.out.println(wrappedValues);
        }
    }

    private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> map) {
        //.remove("a"); можно удалить конкретные слова, например артикль а
        //.replace("a", 5); заменит количество артиклей а на 5
        NavigableSet<WordWrapper> wordSet = new TreeSet<>(); // создаю пустое дерево из элементов типа WordWrapper
        for (Map.Entry<String,Integer> e: map.entrySet()){
            wordSet.add(new WordWrapper(e.getKey(), e.getValue())); //получаю ключ и значения из simpleMap, создаю объект класса WordWrapper, передаю конструктор пару ключ и значение и сохраняю в дерево
        }
        return wordSet;
    }

    private static void simplePrint(Map<String, Integer> map) {
        Map<String,Integer> wordsAsTreeMap = new TreeMap<>(map); //создаю мап в виде дерева и передаю туда мап с полученными из сканера парами для сортировки (в случае с ключом типа String сортировка будет по алфавиту)
        Set<String> keys = wordsAsTreeMap.keySet(); // записываю в сет все ключи
        for(String key: keys){
            System.out.printf("%-15s%-10s \n", key, map.get(key)); // вывожу набор из ключа и значения для этого ключа
        }
    }
}
