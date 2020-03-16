package com.kampaeny.euler.utils;

import java.util.Arrays;

public class PrimeSieve {

	/**
	 * Pre-construct an array of size one million with a value true means its index
	 * is a prime number
	 * 
	 * @return
	 */
	public static boolean[] fillSieve(boolean[] primes) {
		Arrays.fill(primes, true); // assume all integers are prime.
		primes[0] = primes[1] = false; // we know 0 and 1 are not prime.
		for (int i = 2; i < primes.length; i++) {
			// if the number is prime,
			// then go through all its multiples and make their values false.
			if (primes[i]) {
				for (int j = 2; i * j < primes.length; j++) {
					primes[i * j] = false;
				}
			}
		}
		return primes;
	}
}
