package org.example;

public class Rectangle implements Geometry {

    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(
            double width,
            double height,
            String fillColor,
            String borderColor
    ) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter(double... sides) {
        return Geometry.super.getPerimeter(
                width,
                height,
                width,
                height
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