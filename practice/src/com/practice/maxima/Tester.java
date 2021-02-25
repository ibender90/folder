package com.practice.maxima;

import java.io.IOException;
import java.util.Arrays;

public class Tester {
    public static void main(String[] args) throws IOException {
        //GoodsGenerator.writeWithFormatter();
        GoodsReader reader = new GoodsReader("GeneratedGoods.txt");
        System.out.println(Arrays.toString(reader.readInt(2720)));
        //System.out.println(reader.findCode());
        reader.convertToString();
    }
}
