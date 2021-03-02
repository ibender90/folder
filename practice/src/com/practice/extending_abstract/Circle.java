package com.practice.extending_abstract;

public class Circle extends Figure {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    public double area() {
        return (Math.pow(radius, 2)) * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }
}
