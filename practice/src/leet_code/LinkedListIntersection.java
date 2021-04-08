package leet_code;

import java.util.LinkedList;
import java.util.List;

public class LinkedListIntersection {
    public static void main(String[] args) {
        NodeSingleLink node1 = new NodeSingleLink(2);
        NodeSingleLink node2 = new NodeSingleLink(4);
        NodeSingleLink node3 = new NodeSingleLink(5);
        NodeSingleLink node4 = new NodeSingleLink(7);

        List<NodeSingleLink> myList = new LinkedList<>();
        myList.add(node1);
        myList.add(node2);
        myList.add(node3);
        myList.add(node4);

        System.out.println(node2.next);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println(node2.next);

    }
}
