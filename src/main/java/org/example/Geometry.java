package org.example;

public interface Geometry {

    double getArea();

    // Default-метод расчёта периметра
    default double getPerimeter(double... sides) {
        double perimeter = 0;

        for (double side : sides) {
            perimeter += side;
        }

        return perimeter;
    }

    String getFillColor();

    String getBorderColor();
}

class Circle implements Geometry {

    private double radius;
    private String fillColor;
    private String borderColor;

    public Circle(double radius, String fillColor, String borderColor) {
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Rectangle implements Geometry {

    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height,
                     String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return Geometry.super.getPerimeter(
                width, height, width, height
        );
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}

class Triangle implements Geometry {

    private double sideA;
    private double sideB;
    private double sideC;

    private String fillColor;
    private String borderColor;

    public Triangle(double sideA, double sideB, double sideC,
                    String fillColor, String borderColor) {

        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;

        return Math.sqrt(
                p * (p - sideA) *
                        (p - sideB) *
                        (p - sideC)
        );
    }

    public double getPerimeter() {
        return Geometry.super.getPerimeter(
                sideA, sideB, sideC
        );
    }

    @Override
    public String getFillColor() {
        return fillColor;
    }

    @Override
    public String getBorderColor() {
        return borderColor;
    }
}