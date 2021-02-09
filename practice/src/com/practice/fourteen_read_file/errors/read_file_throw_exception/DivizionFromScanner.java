package com.practice.fourteen_read_file.errors.read_file_throw_exception;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DivizionFromScanner {
    public static void main(String[] args) {
        boolean continueLoop = true;
        do {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("please enter numerator ");
                int numerator = scanner.nextInt();
                System.out.println("please enter denominator ");
                int denominator = scanner.nextInt();
                int result = numerator / denominator;
                System.out.println(result);
                saveToFile(result);
                continueLoop = false;
                scanner.close();
            } catch (ArithmeticException e){
                System.out.println(e); // будет выведено стандартное описание ошибки которое находится в классе ArithmeticException
                System.out.println("Cant divide by zero");
            }
            catch (InputMismatchException e){
                System.out.println("please try numbers");
            } catch (IOException e) { //input output exception всегда требует обработки
                System.out.println("unable to access file");
                e.printStackTrace();
            }
        } while (continueLoop);

    }
    private static void saveToFile(int result) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter("division.txt"));
        writer.println(result);
        writer.close();
    }
}
