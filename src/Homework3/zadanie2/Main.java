package Homework3.zadanie2;

public class Main {
    public static void main(String[] args) {

        Shape circle    = new Circle(5, "Красный", "Чёрный");
        Shape rectangle = new Rectangle(4, 6, "Синий", "Белый");
        Shape triangle  = new Triangle(3, 4, 5, "Зелёный", "Жёлтый");

        Shape[] shapes = {circle, rectangle, triangle};

        for (Shape shape : shapes) {
            shape.printInfo();
        }
    }
}
