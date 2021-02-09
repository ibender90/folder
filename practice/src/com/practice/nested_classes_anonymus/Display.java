package com.practice.nested_classes_anonymus;

public class Display {
    private static final int DISPLAY_HEIGHT = 1920;
    private static final int DISPLAY_WIDTH = 1080;
    private Pixel pixel;

    public Display() {
        Pixel pixel = new Pixel(1, 1, Color.BLUE);
    }


    public static class Pixel { // класс должен быть private, чтобы только у класса display был доступ к пикселю
        private int x;
        private int y;
        private Color color;

        public Pixel(int x, int y, Color color) { // вложеный статический класс имеет доступ к статическим полям
            if (x <= DISPLAY_HEIGHT && x >= 0 && y <= DISPLAY_WIDTH && y >= 0) {
                this.x = x;
                this.y = y;
            } else throw new IllegalArgumentException("Screen resolution is " + DISPLAY_HEIGHT + "x" + DISPLAY_WIDTH);
            this.color = color;
        }
    }

    public enum Color {
        RED, GREEN, BLUE
    }


}
