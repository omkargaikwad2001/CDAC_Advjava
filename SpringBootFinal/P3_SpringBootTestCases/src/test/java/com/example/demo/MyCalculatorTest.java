package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyCalculatorTest {

    private static MyCalculator calc;

    @BeforeAll
    static void beforeAllTests() {
        System.out.println("BeforeAll: Executed once before all test cases");
        calc = new MyCalculator();
    }

    @BeforeEach
    void beforeEachTest() {
        System.out.println("BeforeEach: Runs before each test case");
    }

    @Test
    @DisplayName("Testing Addition Operation")
    void testAdd() {
        System.out.println("Running testAdd()");
        assertEquals(15, calc.add(10, 5));
    }

    @Test
    @DisplayName("Testing Subtraction Operation")
    void testSubtract() {
        System.out.println("Running testSubtract()");
        assertEquals(5, calc.subtract(10, 5));
    }

    @Test
    @Disabled("Demonstration: This test is intentionally disabled")
    void disabledTest() {
        System.out.println("This should not be printed!");
        assertEquals(20, calc.add(10, 10));
    }

    @AfterEach
    void afterEachTest() {
        System.out.println("AfterEach: Runs after each test case");
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("⬅ AfterAll: Executed once after all test cases");
    }
}
