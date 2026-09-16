package org.example;

public interface Geometry {

    double getArea();

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