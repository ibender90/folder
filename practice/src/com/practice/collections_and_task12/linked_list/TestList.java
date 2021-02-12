package com.practice.collections_and_task12.linked_list;

public class TestList {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.addTask("Wash floor");
        list.addInAlphabeticalOrder("Wash walls");
        list.addInAlphabeticalOrder("Wash doors");
        list.addInAlphabeticalOrder("Wash holes");
        list.printToConsole();
    }
}
