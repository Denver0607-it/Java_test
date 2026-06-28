package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NumberComparatorTest {

    private NumberComparator comparator;

    @BeforeMethod
    public void setUp() {
        comparator = new NumberComparator();
    }

    @Test(description = "10 > 5 — возвращает 1")
    public void testFirstIsGreater() {
        Assert.assertEquals(comparator.compare(10, 5), 1);
    }

    @Test(description = "3 < 8 — возвращает -1")
    public void testFirstIsLess() {
        Assert.assertEquals(comparator.compare(3, 8), -1);
    }

    @Test(description = "7 == 7 — возвращает 0")
    public void testEqual() {
        Assert.assertEquals(comparator.compare(7, 7), 0);
    }

    @Test(description = "findMax(10, 3) = 10")
    public void testFindMax() {
        Assert.assertEquals(comparator.findMax(10, 3), 10);
    }

    @Test(description = "findMin(10, 3) = 3")
    public void testFindMin() {
        Assert.assertEquals(comparator.findMin(10, 3), 3);
    }

    @Test(description = "Сравнение отрицательных: -5 > -10 — возвращает 1")
    public void testNegativeNumbers() {
        Assert.assertEquals(comparator.compare(-5, -10), 1);
    }
}