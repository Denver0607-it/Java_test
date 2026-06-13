package Homework3.zadanie2;

public interface Shape {

    double area();
    String getFillColor();
    String getBorderColor();
    double[] getSides();

    default double perimeter() {
        double sum = 0;
        for (double side : getSides()) {
            sum += side;
        }
        return sum;
    }

    default void printInfo() {
        System.out.println("Фигура:         " + getClass().getSimpleName());
        System.out.println("Периметр:       " + String.format("%.2f", perimeter()));
        System.out.println("Площадь:        " + String.format("%.2f", area()));
        System.out.println("Цвет заливки:   " + getFillColor());
        System.out.println("Цвет границы:   " + getBorderColor());
        System.out.println("-----------------------------");
    }
}


