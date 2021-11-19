package linkedList;

import java.util.Arrays;

public class MySLL {
    private Node head;
    private int size;

    private class Node{
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public void add(int value){
        if(head == null){
            this.head = new Node(value);
        }
        else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new Node(value));
        }
        size++;
    }

    public int getAt(int index){
        if(index > size || index < 0){
            throw new IllegalArgumentException();
        } else {
            Node temp = head;
            int current = 0;
            while (temp != null){
                if(current == index){
                    return temp.getValue();
                } else {
                    temp = temp.getNext();
                    current++;
                }
            }

        } return 0;
    }

    public void removeAt(int index){
        if(index == 0){
            head = head.getNext();
            size--;
            return;
        }

        Node temp = head;
        int current = 0;
        while(temp != null){
            if(current  == index - 1){ //if next element is one to be deleted
                temp.setNext(temp.getNext().getNext());
                size--;
                return;
            } else {
                temp = temp.getNext();
                current++;
            }
        }
    }

    @Override
    public String toString() {
        int[] list = new int[size];
        Node temp = head;
        int i = 0;
        while(temp != null){
            list[i] = temp.getValue();
            i++;
            temp = temp.getNext();
        }
        return Arrays.toString(list);
    }
}
