package com.kampaeny.euler.tools;

import java.util.Arrays;

public class PrimeTools {

    /**
     * Pre-construct an array of size one million with a value true means its index
     * is a prime number
     */
    public static void fillSieve(boolean[] primes) {
        // assume all integers are prime.
        Arrays.fill(primes, true);
        // we know 0 and 1 are not prime.
        primes[0] = primes[1] = false;
        for (int i = 2; i < primes.length; i++) {
            // if the number is prime,
            // then go through all its multiples and make their values false.
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
    }

}
