package Homework3.zadanie2;

public class Rectangle implements Shape {

    private double width;
    private double height;
    private String fillColor;
    private String borderColor;

    public Rectangle(double width, double height, String fillColor, String borderColor) {
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    @Override
    public double[] getSides() {
        return new double[]{width, height, width, height};
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String getFillColor() { return fillColor; }

    @Override
    public String getBorderColor() { return borderColor; }
}
