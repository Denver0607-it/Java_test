package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test(description = "Сложение: 3 + 4 = 7")
    public void testAdd() {
        Assert.assertEquals(calculator.add(3, 4), 7);
    }

    @Test(description = "Вычитание: 10 - 4 = 6")
    public void testSubtract() {
        Assert.assertEquals(calculator.subtract(10, 4), 6);
    }

    @Test(description = "Умножение: 5 * 6 = 30")
    public void testMultiply() {
        Assert.assertEquals(calculator.multiply(5, 6), 30);
    }

    @Test(description = "Деление: 10 / 2 = 5.0")
    public void testDivide() {
        Assert.assertEquals(calculator.divide(10, 2), 5.0, 0.001);
    }

    @Test(
            description = "Деление на ноль — исключение",
            expectedExceptions = ArithmeticException.class
    )
    public void testDivideByZero() {
        calculator.divide(10, 0);
    }
}