package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Сложение: 3 + 4 = 7")
    void testAdd() {
        assertEquals(7, calculator.add(3, 4));
    }

    @Test
    @DisplayName("Вычитание: 10 - 4 = 6")
    void testSubtract() {
        assertEquals(6, calculator.subtract(10, 4));
    }

    @Test
    @DisplayName("Умножение: 5 * 6 = 30")
    void testMultiply() {
        assertEquals(30, calculator.multiply(5, 6));
    }

    @Test
    @DisplayName("Деление: 10 / 2 = 5.0")
    void testDivide() {
        assertEquals(5.0, calculator.divide(10, 2), 0.001);
    }

    @Test
    @DisplayName("Деление на ноль — исключение")
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10, 0));
    }
}
