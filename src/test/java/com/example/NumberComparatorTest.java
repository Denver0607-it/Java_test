package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberComparatorTest {

    private NumberComparator comparator;

    @BeforeEach
    void setUp() {
        comparator = new NumberComparator();
    }

    @Test
    @DisplayName("10 > 5 → возвращает 1")
    void testFirstIsGreater() {
        assertEquals(1, comparator.compare(10, 5));
    }

    @Test
    @DisplayName("3 < 8 → возвращает -1")
    void testFirstIsLess() {
        assertEquals(-1, comparator.compare(3, 8));
    }

    @Test
    @DisplayName("7 == 7 → возвращает 0")
    void testEqual() {
        assertEquals(0, comparator.compare(7, 7));
    }

    @Test
    @DisplayName("findMax(10, 3) = 10")
    void testFindMax() {
        assertEquals(10, comparator.findMax(10, 3));
    }

    @Test
    @DisplayName("findMin(10, 3) = 3")
    void testFindMin() {
        assertEquals(3, comparator.findMin(10, 3));
    }

    @Test
    @DisplayName("Сравнение отрицательных: -5 > -10 → возвращает 1")
    void testNegativeNumbers() {
        assertEquals(1, comparator.compare(-5, -10));
    }
}