package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialTest {

    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new Factorial();
    }

    @Test
    @DisplayName("0! = 1")
    void testFactorialOfZero() {
        assertEquals(1L, factorial.calculate(0));
    }

    @Test
    @DisplayName("1! = 1")
    void testFactorialOfOne() {
        assertEquals(1L, factorial.calculate(1));
    }

    @Test
    @DisplayName("5! = 120")
    void testFactorialOfFive() {
        assertEquals(120L, factorial.calculate(5));
    }

    @Test
    @DisplayName("10! = 3628800")
    void testFactorialOfTen() {
        assertEquals(3628800L, factorial.calculate(10));
    }

    @Test
    @DisplayName("Отрицательное число — исключение")
    void testNegativeNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial.calculate(-1));
    }
}