/*
The prime 41, can be written as the sum of six consecutive primes:
41 = 2 + 3 + 5 + 7 + 11 + 13

This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/
package com.kampaeny.euler.solved;

import java.util.ArrayList;
import java.util.List;

import com.kampaeny.euler.tools.PrimeTools;

public class Problem050 {
    private static final int MAX_VALUE = 1000000;
    private static final boolean[] primes = new boolean[MAX_VALUE];
    private static final List<Integer> primeNumbersList = new ArrayList<>();

    public static void main(String[] args) {
        PrimeTools.fillSieve(primes);

        for (int a = 0; a < primes.length; a++) {
            if (primes[a]) {
                primeNumbersList.add(a);
            }
        }

        System.out.println(primeNumbersList);

        int totalPrimesUnderMax = primeNumbersList.size();
        int tempSum;
        int tempSum2 = 0;
        int innerBound = 0;
        int outerBound = totalPrimesUnderMax - 1;
        int maxTerms1;
        int maxTerms2 = 0;

        while (innerBound <= outerBound) {
            tempSum = 0;
            maxTerms1 = 0;

            for (int i = innerBound; i <= outerBound; i++) {
                tempSum += primeNumbersList.get(i);

                ++maxTerms1;

                if (tempSum > primeNumbersList.get(outerBound)) {
                    break;
                } else if (primeNumbersList.contains(tempSum)) {
                    if (maxTerms2 < maxTerms1) {
                        maxTerms2 = maxTerms1;
                        tempSum2 = tempSum;
                    }
                }
            }

            ++innerBound;
        }

        System.out.println("Max Prime = " + tempSum2);
        System.out.println("Max Terms = " + maxTerms2);
    }
}
