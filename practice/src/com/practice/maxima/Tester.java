package com.practice.maxima;

import java.io.IOException;

public class Tester {
    public static void main(String[] args) throws IOException {
/*        //GoodsGenerator.writeWithFormatter();
        //GoodsReaderAlfa reader = new GoodsReaderAlfa("GeneratedGoods.txt");
        //System.out.println(Arrays.toString(reader.readInt(2720)));
        //System.out.println(reader.findCode());
        //reader.convertToString();*/

        GoodsReaderBeta smartReader = new GoodsReaderBeta("GeneratedGoods.txt");
        ProductScanner codeScanner = new ProductScanner();

        int checkedInput = codeScanner.checkCode();
        String product = smartReader.findProduct(checkedInput);
        System.out.println(product);
    }
}
