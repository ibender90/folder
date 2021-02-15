package com.practice.collections_and_task12.map;

import java.util.Objects;

public final class WordWrapper implements Comparable<WordWrapper> { //класс обёртка для слов из коллекции map, создан для сортировки и упорядоченного вывода
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
        } else return word.compareTo(pair.getWord()); // очень важно сравнить слова повторяющиеся одинаковое количество раз, иначе они будут потеряны
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
