package org.example;

public class Triangle implements Geometry {

    private double sideA;
    private double sideB;
    private double sideC;

    private String fillColor;
    private String borderColor;

    public Triangle(
            double sideA,
            double sideB,
            double sideC,
            String fillColor,
            String borderColor
    ) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        double halfPerimeter = getPerimeter() / 2;

        return Math.sqrt(
                halfPerimeter *
                        (halfPerimeter - sideA) *
                        (halfPerimeter - sideB) *
                        (halfPerimeter - sideC)
        );
    }

    @Override
    public double getPerimeter(double... sides) {
        return Geometry.super.getPerimeter(
                sideA,
                sideB,
                sideC
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