package com.practice.b_tree;

public class TreeRunner {
    public static void main(String[] args) {
        B_Tree tree = new B_Tree();
        tree.addValue(4);
        tree.addValue(2);
        tree.addValue(5);
        tree.addValue(1);
        tree.addValue(3);
        tree.addValue(7);
        tree.addValue(6);
        tree.addValue(8);
        tree.printTree();
    }
}
