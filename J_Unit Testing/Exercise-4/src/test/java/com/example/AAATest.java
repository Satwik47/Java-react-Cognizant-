package com.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class AAATest {
    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setting up test data...");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Cleaning up resources...");
        calculator = null;
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 10;
        int b = 5;
        // Act
        int result = calculator.add(a, b);
        // Assert
        assertEquals(15, result);
    }
}
