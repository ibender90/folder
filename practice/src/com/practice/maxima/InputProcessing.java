package com.practice.maxima;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Scanner;

public class InputProcessing {
    private int[] correctCode = {32,32,32,32,32,32,32,32};
    private int codeLength;

    public int checkCode() {
        Scanner scanner = new Scanner(System.in);
        boolean correctInput = false;
        int digitalCode = 0;
        while (!correctInput) {
            System.out.println("Please enter code: ");
            String code = scanner.next();

            try {
                digitalCode = Integer.parseInt(code);
                if ((digitalCode > 99) && (digitalCode <= 12345678)) {
                    correctInput = true;
                } else System.out.println("code is out of range");
            } catch (NumberFormatException e) {
                System.out.println("Incorrect number, code should consist of 3-8 digits");
            }


        }
        scanner.close();
        return digitalCode;
    }

    public int getCodeLength(int code) {
        int length = 0;
        while (code % 10 == 0) {
            length++;
            code = code / 10;
        }
        codeLength = length;
        return length;
    }

    public void getCorrectCode(int code){ //not working
        int length = getCodeLength(code);
        ByteBuffer dbuf = ByteBuffer.allocate(length);
        dbuf.putInt((short) code);
        byte[] bytes = dbuf.array();
        System.out.println(Arrays.toString(bytes));

    }

}
