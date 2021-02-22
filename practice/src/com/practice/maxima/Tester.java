package com.practice.maxima;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
        GoodsGenerator.writeWithFormatter();
        GoodsReader reader = new GoodsReader("GeneratedGoods.txt");
        //System.out.println(reader.readFrom(10));
        //System.out.println(reader.readLine(1));
        //System.out.println(Arrays.toString(reader.readBytes(1)));
        System.out.println(reader.readLine((reader.searchSameLength(5))));
        //reader.howManyLines();
        //reader.printLineNumber(5);
        //System.out.println(reader.higherOrLower(4000));

    }
}
