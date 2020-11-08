package com.stringCalculator;

import java.util.ArrayList;
import java.util.List;

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

        String delimiter = "[,\n]";
        if (numbers.trim().startsWith("//")) {
            if (!numbers.contains("\n"))
                throw new IllegalArgumentException("input string invalid. new delimiter not in valid format" +
                        "Valid format : [//<delimiter>\\n]");
            delimiter = numbers.substring(2, numbers.indexOf("\n"));
            numbers = numbers.substring(numbers.indexOf("\n"));
        }

        String[] numArray = numbers.trim().split(delimiter);
        if (numArray.length == 1) return Integer.parseInt(numArray[0]);

        int sum = 0;
        List<String> negativeNums = new ArrayList<>();
        for (String s : numArray) {
            if (Utility.checkEmptyString(s)) continue;
            try {
                int num = Integer.parseInt(s.trim());
                if (num < 0) negativeNums.add("" + num);
                else sum += num;
            } catch (NumberFormatException e) {
                System.err.println("Passed input [" + s + "] not a valid integer");
            }
        }

        if (negativeNums.size() > 0)
            System.err.println("Negatives not allowed [" + String.join(",", negativeNums) + "]");
        return sum;
    }
}
