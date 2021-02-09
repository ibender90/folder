package com.practice.third;

import java.util.Scanner;

public class ThirdTaskSwitch {
    public static void main(String[] args) {

        Scanner scanCity = new Scanner(System.in);

        String city = "";

        while (!city.equalsIgnoreCase("stop")) {
            System.out.println("Введите город: ");
            city = scanCity.next();
            switch (city) {
                case "Москва":
                case "Владивосток":
                case "Ростов":
                    System.out.println("Россия");
                    break;
                case "Лондон":
                case "Манчестер":
                case "Ливерпуль":
                    System.out.println("Англия");
                    break;
                default:
                    System.out.println("Неизвестная страна");
            }
        }
        // alternative solution
        Scanner scanCountry = new Scanner(System.in);
        while (true){
            System.out.println("введите страну");
            String country = scanCountry.nextLine();

            if (country.equalsIgnoreCase("stop"))
                break;

            switch (country) {
                case "Россия":
                    System.out.println("Русский");
                    break;
                case "Англия":
                    System.out.println("Англичанин");
                    break;
                default:
                    System.out.println("alien");
            }
        }
    }
}

