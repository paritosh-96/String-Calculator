package com.stringCalculator;

/**
 * Author : Paritosh
 * Date : 08/11/20
 * <p>
 * The String calculator Class which exposes methods for simple calculations
 */
public class StringCalculator {

    /**
     * function to add 2 numbers given as a string separated by comma
     *
     * @param numbers - string containing numbers to add
     * @return - sum of the input numbers
     */
    public int add(String numbers) {
        // if the input string is empty or null
        if (Utility.checkEmptyString(numbers)) return 0;

        String[] numArray = numbers.trim().split("[,\n]");
        if (numArray.length == 1) return Integer.parseInt(numArray[0]);

        int sum = 0;
        for (String s : numArray) {
            if (Utility.checkEmptyString(s)) continue;
            try {
                sum += Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.err.println("Passed input [" + s + "] not a valid integer");
            }
        }
        return sum;
    }
}
