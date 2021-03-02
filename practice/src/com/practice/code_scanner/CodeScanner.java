package com.practice.code_scanner;

import java.util.Scanner;

public class CodeScanner {

    public static int checkCode() {
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

}
