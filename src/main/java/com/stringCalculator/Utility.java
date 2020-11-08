package com.stringCalculator;

/**
 * Author : Paritosh
 * Date : 08/11/20
 * <p>
 * Util class provides utility functions for the application.
 */
public class Utility {

    /**
     * function to check if the given string is null or empty
     *
     * @param s - input string to check
     * @return - return true if the the string is null or empty
     */
    public static boolean checkEmptyString(String s) {
        return (s == null || s.trim().isEmpty());
    }
}
