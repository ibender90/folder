package com.practice.extending_abstract;
//Первый метод, принимая на вход массив геометрических фигур, должен вернуть
//        сумму периметров красных фигур. Второй метод, принимая на вход массив
//        геометрических фигур, должен вернуть сумму площадей красных фигур.
//        Вызовите эти два метода на массиве figures и выведите результат в консоль.

public class Task2AbstractTestfigures {
    public static void main(String[] args) {
        Figure[] figures1 = {
                new Triangle("Red", 10, 10, 10),
                new Triangle("Green", 10, 20, 30),
                new Triangle("Red", 10, 20, 15),
                new Rectangle("Red", 5, 10),
                new Rectangle("Orange", 40, 15),
                new Circle("Red", 4),
                new Circle("Red", 10),
                new Circle("Blue", 5)
        };
        Figure[] figures2 = {
                new Triangle("Red", 12, 13, 10),
                new Triangle("Green", 15, 20, 30),
                new Triangle("Red", 10, 20, 15),
                new Rectangle("Red", 5, 10),
                new Rectangle("Orange", 40, 15),
                new Circle("Red", 7),
                new Circle("Blue", 3),
                new Circle("Blue", 2)
        };
        System.out.println(calculateRedArea(figures1));
        System.out.println(calculateRedPerimeter(figures1));
        System.out.println(calculateRedPerimeter(figures2));
        System.out.println(calculateRedArea(figures2));

    }

        public static double calculateRedPerimeter(Figure[] arr){
            double sumOfRedPerimeters = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].getColor().equalsIgnoreCase("Red")) {
                    sumOfRedPerimeters += arr[i].perimeter();
                }
            }
            return sumOfRedPerimeters;
        }

        public static double calculateRedArea(Figure[] someArr){
            double sumOfRedAreas = 0;
            for (int i = 0; i < someArr.length; i++) {
                if (someArr[i].getColor().equalsIgnoreCase("Red")) {
                    sumOfRedAreas += someArr[i].area();
                }
            }
            return sumOfRedAreas;
        }
    }

