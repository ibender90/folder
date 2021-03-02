package com.practice.code_scanner;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        //CodeAndNameGenerator.writeWithFormatter();

        CodeReader smartReader = new CodeReader("GeneratedGoods.txt");

        String product = smartReader.findProduct(CodeScanner.checkCode());
        System.out.println(product);
    }
}
