package com.practice.collections_task12.linked_list;

import java.util.Arrays;
import java.util.LinkedList;

public class ColorsArrayToList {
    public static void main(String[] args) {
        String[] colors = {"red, green"};
        LinkedList<String> temp = new LinkedList<>(Arrays.asList(colors)); // создаю линкед лист из массива, чтобы добавить ещё 1 элемент
        temp.add("blue");
        colors = temp.toArray(new String[temp.size()]); // сохраняю новый массив в переменную color
    }
}
