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
     * @param s
     * @return
     */
    public static String addEscape(String s) {
        if (".$|()[{^?*+".contains(s.charAt(0) + "")) {
            StringBuilder escapedString = new StringBuilder();
            for (char c : s.trim().toCharArray()) escapedString.append("\\").append(c);
            return escapedString.toString();
        }
        return s;
    }
}
