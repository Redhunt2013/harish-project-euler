/*
We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
For example, 2143 is a 4-digit pandigital and is also prime.
What is the largest n-digit pandigital prime that exists?

NOTE:- There was no upper limit provided in the website. Upper limit to this problem was determined based on the logic below:-
a number is divisible by 3 if and only if the digit sum of the number is divisible by 3. The digit sum is as the name implies the sum of the digits. We can rather easily find the digit sum of pandigital numbers since we know the digits.
1+2+3+4+5+6+7+8+9 = 45
1+2+3+4+5+6+7+8 = 36
1+2+3+4+5+6+7 = 28
1+2+3+4+5+6 = 21
1+2+3+4+5 = 15
1+2+3+4 = 10
1+2+3 = 6
1+2 = 3

From here it is pretty clear that all pandigital numbers except 4 and 7 digit ones are divisible by 3 and thus can�t be primes.
*/
package com.kampaeny.euler.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.kampaeny.euler.tools.Audit;
import com.kampaeny.euler.tools.PrimeTools;

public class Problem041 {

    private static final int ONE_MILLION = 10000000;
    private static final boolean[] primes = new boolean[ONE_MILLION];
    private static final List<Integer> lstPandigitalPrimes = new ArrayList<>();

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        // construct the prime array
        PrimeTools.fillSieve(primes);
        for (int a = 0; a < primes.length; a++) {
            if (primes[a]) {
                if (isPandigital(String.valueOf(a))) {
                    lstPandigitalPrimes.add(a);
                }
            }
        }
        System.out.println("Total pandigitals primes found: " + lstPandigitalPrimes.size() + " under: " + ONE_MILLION);
        System.out.println("##########################");
        System.out.println("Max pandigital prime = " + Collections.max(lstPandigitalPrimes));
        System.out.println("##########################");
        System.out.println("Total Time Taken: " + (Audit.timeTaken(startTime, System.currentTimeMillis()) / 1000) + " seconds");
    }

    /* ################################################## */
    /* All utility methods go below. */
    /* ################################################## */

    /**
     * Finds and returns if true if the number is pandigital
     *
     * @param strPan - a string to check pandigital
     * @return true or false
     */
    private static boolean isPandigital(final String strPan) {
        final int length = strPan.trim().length();
        boolean[] numerals = new boolean[length];
        Arrays.fill(numerals, false);
        int iPan = Integer.valueOf(strPan.trim());
        int digit;
        while (iPan > 0) {
            digit = iPan % 10;
            iPan /= 10;
            if (digit > 0 && digit <= length)
                numerals[digit - 1] = true;
        }
        for (final boolean pandigit : numerals) {
            // if an index i is 'false', it means that one of the 1-9 digits was not present in the string supplied to this method so return false
            if (!pandigit) {
                return false;
            }
        }
        // if it reaches this point, number is a pandigital. Check if its prime too.
        return true;
    }

}
