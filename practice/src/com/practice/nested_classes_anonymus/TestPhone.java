package com.practice.nested_classes_anonymus;

public class TestPhone {
    public static void main(String[] args) {
        Smartphone samsung = new Smartphone();
        samsung.turnOn();

        Display display = samsung.getDisplay();
        Display.Pixel pixel = new Display.Pixel(12,12,Display.Color.BLUE); //объект вложенного статического класса ТОЛЬКО ДЛЯ ПРИМЕРА
    }
}
