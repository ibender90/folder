package com.practice.complex_wordcounter;

import java.util.*;

import static com.practice.complex_wordcounter.WordCounter.isNumber;

public class WordSaver {

    public static Map<String, Integer> countEveryWord(Scanner scanner) {
        Map<String, Integer> simpleMap = new HashMap<>(); //декларирую мап, где ключом будет строка, а значением число
        while (scanner.hasNextLine()) {
            String scannedLines = scanner.nextLine();
            StringTokenizer tokenizer = new StringTokenizer(scannedLines, "^%$#*'\\\\\" ,\\?!@:;-\\+&/\\.\\(\\)");
            while (tokenizer.hasMoreTokens()) {
                String token = tokenizer.nextToken();
                if (!isNumber(token)) {
                    String key = token.toLowerCase();
                    Integer counter = simpleMap.get(key); //спрашиваю каждый раз, есть ли такая пара в мапе
                    if (counter == null) {
                        simpleMap.put(key, 1); //если не получаю значения по этому ключу, записываю единицу
                    } else
                        simpleMap.put(key, counter + 1); // если получаю какое-то число, увеличиваю его на 1 и перезаписываю пару
                }
            }
        }
        return simpleMap;
    }

    public static void thisWordRepeats(Map<String, Integer> where, String word){
        System.out.println(where.get(word));
    }

    public static void simplePrint(Map<String, Integer> map) {
        Map<String, Integer> wordsAsTreeMap = new TreeMap<>(map); //создаю мап в виде дерева и передаю туда мап с полученными из сканера парами для сортировки (в случае с ключом типа String сортировка будет по алфавиту)
        Set<String> keys = wordsAsTreeMap.keySet(); // записываю в сет все ключи
        for (String key : keys) {
            System.out.printf("%-15s%-10s \n", key, map.get(key)); // вывожу набор из ключа и значения для этого ключа
        }
    }

    public static void sortedPrint(Map<String, Integer> map) {
        NavigableSet<WordWrapper> sortedByValue = convertToSet(map);
        for (WordWrapper wrappedValues : sortedByValue) { // беру каждый элемент множества и использую его toString имплементацию
            System.out.println(wrappedValues);
        }
    }

    private static NavigableSet<WordWrapper> convertToSet(Map<String, Integer> map) {
        NavigableSet<WordWrapper> wordSet = new TreeSet<>(); // создаю пустое дерево из элементов типа WordWrapper
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            wordSet.add(new WordWrapper(e.getKey(), e.getValue())); //получаю ключ и значения из simpleMap, создаю объект класса WordWrapper, передаю конструктор пару ключ и значение и сохраняю в дерево
        }
        return wordSet;
    }

    public static final class WordWrapper implements Comparable<WordWrapper> { //класс обёртка для слов из коллекции map, создан для сортировки и упорядоченного вывода
        private final String word;
        private final Integer count;

        public WordWrapper(String word, Integer key) {
            this.word = word;
            this.count = key;
        }

        public Integer getCount() {
            return count;
        }

        public String getWord() {
            return word;
        }

        @Override
        public int compareTo(WordWrapper pair) {
            if (count < pair.getCount()) { // сравниваем пары по значению, меньшее будет вверху, большее внизу списка
                return -1;
            }
            if (count > pair.getCount()) {
                return 1;
            } else
                return word.compareTo(pair.getWord()); // очень важно сравнить слова повторяющиеся одинаковое количество раз, иначе они будут потеряны
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WordWrapper that = (WordWrapper) o;
            return Objects.equals(word, that.word) && Objects.equals(count, that.count);
        }

        @Override
        public int hashCode() {
            return Objects.hash(word, count);
        }

        @Override
        public String toString() {
            return word + " repeats " + count + " time(s)";
        }

    }
}
