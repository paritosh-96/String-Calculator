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

    /**
     * function to add escape sequence to special characters in a regex
     *
     * @param s -input string
     * @return - escaped string
     */
    public static String addEscape(String s) {
        StringBuilder escapedString = new StringBuilder();
        for (char c : s.trim().toCharArray()) {
            if (".$|()[{^?*+".contains(c + "")) escapedString.append("\\").append(c);
            else escapedString.append(c);
        }
        return escapedString.toString();
    }
}
