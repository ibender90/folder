package com.practice.b_tree;

public class B_Tree {
    private Node root;

    private static class Node {
        int value;
        Node leftSmallSon;
        Node rightBigSon;

        public Node(int value){
            this.value = value;
        }
    }

    public void addValue(int value) {
        Node node = new Node(value);
        if (root == null){
            root = node;
        } else assignSon(node);
    }

    private void assignSon(Node node) {
        Node pointer = root;
        boolean assigned = false;

        while (!assigned && (pointer.value != node.value)){
            if(node.value < pointer.value) {
                if(pointer.leftSmallSon == null){
                    pointer.leftSmallSon = node;
                    assigned = true;
                } else {
                    pointer = pointer.leftSmallSon;
                }
            } else {
                if(pointer.rightBigSon == null){
                    pointer.rightBigSon = node;
                    assigned = true;
                } else {
                    pointer = pointer.rightBigSon;
                }
            }
        }
    }

    public void printTree(){
        printNode(root);
    }
    private void printNode(Node node){
        if(node != null){
            printNode(node.leftSmallSon);
            System.out.println(node.value);
            printNode(node.rightBigSon);
        }
    }
}
