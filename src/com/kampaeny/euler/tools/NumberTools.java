/*
  Util class to work on digits
 */
package com.kampaeny.euler.tools;

import java.math.BigDecimal;
import java.math.BigInteger;

public class NumberTools {

    /**
     * Find total number of digits
     *
     * @param value to find total number of digits for
     * @return int - number of digits
     */
    public static int numberOfDigits(int value) {
        int digits = 0;
        while (value > 0) {
            ++digits;
            value /= 10;
        }
        return digits;
    }

    /**
     * Find total number of digits
     *
     * @param value to find total number of digits for
     * @return int - number of digits
     */
    public static int numberOfDigits(BigDecimal value) {
        int digits = 0;
        while (value.compareTo(new BigDecimal(0)) > 0) {
            ++digits;
            value = value.divide(new BigDecimal(10));
            if (value.compareTo(BigDecimal.TEN) < 0) {
                System.out.println(value);
            }
        }
        return digits;
    }

    /**
     * Find digits on an integer
     *
     * @param value to find digits for
     * @return String[]
     */
    public static int digitize(int value) {
        int digits = 0;
        while (value > 0) {
            ++digits;
            value = value % 10;
            value /= 10;
        }
        return digits;
    }

    /**
     * Split into digits and find sum total of digits
     *
     * @return sum of digits
     */
    public static int splitIntoDigitsAndSum(int value) {
        return totalDigits(String.valueOf(value));
    }

    private static int totalDigits(final String number) {
        int sum = 0;
        for (int j = 0; j < number.length(); j++) {
            int k = Character.digit(number.charAt(j), 10);
            sum += k;
        }
        return sum;
    }

    /**
     * Split into digits and find sum total of digits
     *
     * @return sum of digits
     */
    public static int splitIntoDigitsAndSum(long value) {
        return totalDigits(String.valueOf(value));
    }

    /**
     * Split into digits and find sum total of digits
     *
     * @return sum of digits
     */
    public static int splitIntoDigitsAndSum(final BigInteger value) {
        return totalDigits(String.valueOf(value));
    }

}
