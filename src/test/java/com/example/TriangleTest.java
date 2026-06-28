package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriangleTest {

    private Triangle triangle;

    @BeforeMethod
    public void setUp() {
        triangle = new Triangle();
    }

    @Test(description = "Прямоугольный треугольник 3-4-5: площадь = 6.0")
    public void testRightTriangle() {
        Assert.assertEquals(triangle.calculateArea(3, 4, 5), 6.0, 0.001);
    }

    @Test(description = "Равносторонний треугольник со стороной 2")
    public void testEquilateralTriangle() {
        Assert.assertEquals(triangle.calculateArea(2, 2, 2), Math.sqrt(3), 0.001);
    }

    @Test(
            description = "Нулевая сторона — исключение",
            expectedExceptions = IllegalArgumentException.class
    )
    public void testZeroSide() {
        triangle.calculateArea(0, 4, 5);
    }

    @Test(
            description = "Отрицательная сторона — исключение",
            expectedExceptions = IllegalArgumentException.class
    )
    public void testNegativeSide() {
        triangle.calculateArea(-1, 4, 5);
    }

    @Test(
            description = "Несуществующий треугольник — исключение",
            expectedExceptions = IllegalArgumentException.class
    )
    public void testInvalidTriangle() {
        triangle.calculateArea(1, 2, 10);
    }
}