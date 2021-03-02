package com.practice.extending_abstract;
//2. Создайте абстрактный класс Фигура (англ. Figure). Этот класс будет являться
//        абстрактным представлением геометрической фигуры в нашей программе.
//        У всех фигур в нашей программе есть цвет, поэтому в классе Фигура есть строковое
//        поле color . Создайте конструктор, геттер и сеттер для этого поля.
//        У класса Фигура определены два абстрактных метода:
//public abstract double area();
//public abstract double perimeter();
//        Реализация первого метода должна возвращать площадь фигуры, а реализация
//        второго метода должна возвращать периметр фигуры.
//        Создайте 3 геометрические фигуры: Круг (англ. Circle ), Прямоугольник (англ.
//        Rectangle ) и Треугольник (англ. Triangle ). Каждая из фигур должна наследоваться
//        от абстрактного класса Фигура (англ. Figure ).
//        У класса Круг будет одно поле - радиус окружности.
//        У класса Прямоугольник будет два поля - ширина и высота.
//        У класса Треугольник будет три поля - длина каждой из сторон.
//        Для каждого из этих трех классов необходимо реализовать конструктор, который
//        принимает на вход размерности фигуры и цвет фигуры.
//        В этих же классах, вам необходимо реализовать два метода ( area() и
//        perimeter() ). Реализация этих методов будет разной для каждой из геометрических
//        фигур. Формулы для вычисления площади и периметра легко находятся в интернете.
//        После того, как геометрические фигуры будут полностью реализованы, вам
//        необходимо будет реализовать еще один класс - TestFigures .
public abstract class Figure {
    private String color;

    public Figure(String color) {
        this.color = color;
    }
    public abstract double area();
    public abstract double perimeter();

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}