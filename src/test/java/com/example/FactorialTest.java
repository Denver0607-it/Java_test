package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FactorialTest {

    private Factorial factorial;

    @BeforeMethod
    public void setUp() {
        factorial = new Factorial();
    }

    @Test(description = "0! = 1")
    public void testFactorialOfZero() {
        Assert.assertEquals(factorial.calculate(0), 1L);
    }

    @Test(description = "1! = 1")
    public void testFactorialOfOne() {
        Assert.assertEquals(factorial.calculate(1), 1L);
    }

    @Test(description = "5! = 120")
    public void testFactorialOfFive() {
        Assert.assertEquals(factorial.calculate(5), 120L);
    }

    @Test(description = "10! = 3628800")
    public void testFactorialOfTen() {
        Assert.assertEquals(factorial.calculate(10), 3628800L);
    }

    @Test(
            description = "Отрицательное число — исключение",
            expectedExceptions = IllegalArgumentException.class
    )
    public void testNegativeNumber() {
        factorial.calculate(-1);
    }
}