/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.

The product 7254 is unusual, as the identity, 39 � 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.

Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
*/
package com.kampaeny.euler.solved;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.kampaeny.euler.tools.Audit;

public class Problem032 {

    private static final int MAX_DIGIT = 9;
    private static final long ONE_MILLION = 1000000L;

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        String concat = null;
        boolean bPanDigital;
        final Set<Integer> lstPandigitals = new HashSet<>();
        final Set<Integer> setProducts = new HashSet<>();
        int totalPandigitalSum = 0;
        for (long i = 1; i <= ONE_MILLION; i++) {
            if (concat == null) {
                concat = "";
            }
            for (long j = 1; j <= ONE_MILLION; j++) {
                concat = concat + i + j + i * j;
                if (concat.length() > MAX_DIGIT) {
                    concat = "";
                    break;
                } else {
                    if (concat.length() == 9) {
                        bPanDigital = isPandigital(concat);
                        if (bPanDigital) {
                            lstPandigitals.add(Integer.valueOf(concat));
                            setProducts.add(Integer.valueOf(String.valueOf(i * j)));
                        }
                    }
                }
                concat = "";
            }
        }
        for (final int k : setProducts) {
            totalPandigitalSum += k;
        }
        System.out.println("Total pandigitals found: " + lstPandigitals.size());
        System.out.println(lstPandigitals);
        System.out.println("Sum of pandigital products found = " + totalPandigitalSum);
        System.out.println("Total Time Taken: " + (Audit.timeTaken(startTime, System.currentTimeMillis()) / 1000) + " seconds");
    }

    private static boolean isPandigital(final String strPan) {
        // if the string is more than 9 in length, don't bother to proceed further since
        // it is not going to 1-9 pandigital
        if (strPan.length() > MAX_DIGIT || strPan.length() < MAX_DIGIT) {
            return false;
        }
        boolean[] numerals = new boolean[MAX_DIGIT];
        Arrays.fill(numerals, false);
        long iPan = Long.valueOf(strPan.trim());
        long digit;
        while (iPan > 0) {
            digit = iPan % 10;
            iPan /= 10;
            if (digit > 0) {
                numerals[Integer.parseInt(String.valueOf(digit - 1))] = true;
            }
        }
        for (boolean pandigit : numerals) {
            // if an index i is 'false', it means that one of the 1-9 digits was not present
            // in the string supplied to this method so return false
            if (!pandigit) {
                return false;
            }
        }
        return true;
    }

}
