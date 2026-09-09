package org.example;

public class TriangleArea {

    public static double calculate(double base, double height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException(
                    "Base and height must be positive"
            );
        }

        return base * height / 2.0;
    }
}