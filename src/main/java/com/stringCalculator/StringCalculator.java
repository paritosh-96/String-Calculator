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
            //condition for multiple or longer delimiter
            if (numbers.contains("[")) {
                int curr_ind = 2;
                char curr = numbers.charAt(2);
                StringBuilder givenDelimiter = new StringBuilder();
                StringBuilder del = new StringBuilder();
                while (numbers.indexOf("\n") != curr_ind) {
                    if (curr == ']') {
                        if (givenDelimiter.length() != 0) givenDelimiter.append("|");
                        givenDelimiter.append(Utility.addEscape(del.toString()));
                        del = new StringBuilder();
                    } else if (curr != '[') del.append(curr);
                    curr = numbers.charAt(++curr_ind);
                }
                delimiter = givenDelimiter.toString();
            } else {
                delimiter = numbers.substring(2, numbers.indexOf("\n"));
            }
            numbers = numbers.substring(numbers.indexOf("\n") + 1);
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
                else if (num <= 1000) sum += num;
            } catch (NumberFormatException e) {
                System.err.println("Passed input [" + s + "] not a valid integer");
            }
        }

        if (negativeNums.size() > 0)
            System.err.println("Negatives not allowed [" + String.join(",", negativeNums) + "]");
        return sum;
    }
}
