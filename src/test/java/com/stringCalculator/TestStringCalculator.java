package com.stringCalculator;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Author : Paritosh
 * Date : 08/11/20
 * <p>
 * Test class to test all functionalities in StringCalculator class
 */
public class TestStringCalculator {

    static StringCalculator calculator;

    @BeforeClass
    public static void init() {
        calculator = new StringCalculator();
    }

    /**
     * Test function to test the add function in StringCalculator class
     */
    @Test
    public void testAdd() {
        //positive test cases with max two numbers
        assertEquals(0, calculator.add(""));
        assertEquals(1, calculator.add("1,"));
        assertEquals(3, calculator.add("1,2"));
        assertEquals(1, calculator.add(",1"));

        //positive test cases with more than 2 numbers
        assertEquals(36, calculator.add("1,2,3,4,5,6,7,8"));
        assertEquals(160, calculator.add("10,20,30,40,50,10,"));
    }
}
