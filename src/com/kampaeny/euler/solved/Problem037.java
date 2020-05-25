/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/
package com.kampaeny.euler.solved;

import java.util.ArrayList;
import java.util.List;

import com.kampaeny.euler.tools.NumberTools;
import com.kampaeny.euler.tools.PrimeTools;

public class Problem037 {

    private static final int ONE_MILLION = 1000000;
    private static final boolean[] primes = new boolean[ONE_MILLION];

    public static void main(String[] args) {
        int primeSum = 0;
        final List<Integer> truncPrimeList = new ArrayList<>();
        // construct the prime array
        PrimeTools.fillSieve(primes);
        for (int i = 8; i < primes.length; i++) {
            if (isTruncatablePrime(i)) {
                truncPrimeList.add(i);
            }
        }
        for (int j = 0; j < 11; j++) {
            primeSum = primeSum + truncPrimeList.get(j);
        }
        System.out.println("####################");
        System.out.println("Final Sum = " + primeSum);
        System.out.println("####################");
    }

    private static boolean isTruncatablePrime(int t) {
        boolean bTruncatablePrime = false;
        final int root = 10;
        final int power = NumberTools.numberOfDigits(t);
        if (isPrime(t)) {
            // left-to-right
            bTruncatablePrime = isPrime(t % root);
            for (int i = 1; i < power; i++) {
                if (bTruncatablePrime) {
                    bTruncatablePrime = isPrime(t % ((int) Math.pow(root, i)));
                } else {
                    break; // if one of the value is false, dont bother to calculate others
                }
            }
            // right-to-left. proceed only if master value is prime and left-to-right is prime
            if (bTruncatablePrime) {
                for (int i = 1; i < power; i++) {
                    if (bTruncatablePrime) {
                        bTruncatablePrime = isPrime(t / ((int) Math.pow(root, i)));
                    } else {
                        break; // if one of the value is false, dont bother to calculate others
                    }
                }
            }
            // if 'b' is still true, it is a truncatable prime
            if (bTruncatablePrime) {
                System.out.println("### Truncatable Prime ### = " + t);
            }
        }
        return bTruncatablePrime;
    }

    private static boolean isPrime(final int n) {
        return primes[n];
    }

}
