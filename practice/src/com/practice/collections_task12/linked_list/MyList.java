package com.practice.collections_task12.linked_list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class MyList {
    LinkedList<String> tasks = new LinkedList<>();

    public void addTask(String task){
        tasks.add(task);
    }
    public boolean addInAlphabeticalOrder(String task){
        ListIterator<String> itSorts = tasks.listIterator();
        while (itSorts.hasNext()){
            int compared = itSorts.next().compareTo(task);
            if(compared == 0){ //если задачи совпадают, метод compareTo возвращает ноль
                System.out.println("this task already exists");
                return true;
            }
            else if(compared > 0){
                itSorts.previous();
                itSorts.add(task);
                return true;
            }
        }
        tasks.add(task); //если задача поданная методу является первой в списке, то её не с чем сравнивать и она просто добавляется
        return true;
    }


    public void printToConsole(){
        Iterator<String> iterator = tasks.iterator(); // создать итератор для моего списка строк
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
