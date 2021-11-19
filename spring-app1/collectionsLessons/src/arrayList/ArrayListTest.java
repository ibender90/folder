package arrayList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> someList = new ArrayList<>();
        for(int i = 0; i<10; i++){
            someList.add(i);
        }
        System.out.println(someList);

        someList = new LinkedList<>(someList);
        //for effective removal of elements is better to use linked list

        someList.remove(5);
        System.out.println(someList);
    }
}
