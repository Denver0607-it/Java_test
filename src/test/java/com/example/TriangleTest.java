package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    private Triangle triangle;

    @BeforeEach
    void setUp() {
        triangle = new Triangle();
    }

    @Test
    @DisplayName("Прямоугольный треугольник 3-4-5: площадь = 6.0")
    void testRightTriangle() {
        assertEquals(6.0, triangle.calculateArea(3, 4, 5), 0.001);
    }

    @Test
    @DisplayName("Равносторонний треугольник со стороной 2")
    void testEquilateralTriangle() {
        assertEquals(Math.sqrt(3), triangle.calculateArea(2, 2, 2), 0.001);
    }

    @Test
    @DisplayName("Нулевая сторона — исключение")
    void testZeroSide() {
        assertThrows(IllegalArgumentException.class,
                () -> triangle.calculateArea(0, 4, 5));
    }

    @Test
    @DisplayName("Отрицательная сторона — исключение")
    void testNegativeSide() {
        assertThrows(IllegalArgumentException.class,
                () -> triangle.calculateArea(-1, 4, 5));
    }

    @Test
    @DisplayName("Несуществующий треугольник 1-2-10 — исключение")
    void testInvalidTriangle() {
        assertThrows(IllegalArgumentException.class,
                () -> triangle.calculateArea(1, 2, 10));
    }
}