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

From here it is pretty clear that all pandigital numbers except 4 and 7 digit ones are divisible by 3 and thus can’t be primes.
*/
package com.kampaeny.euler.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.kampaeny.euler.utils.PrimeSieve;

public class Problem041 
{
	static final int ONE_MILLION = /*Integer.MAX_VALUE*/ 10000000;
	static boolean[] primes = new boolean[ONE_MILLION]; 
	static boolean[] primePandigital = new boolean[ONE_MILLION];
	static List<Integer> lstPandigitalPrimes = new ArrayList<Integer>();

	public static void main(String args[])
	{
		//construct the prime array
		primes = PrimeSieve.fillSieve(primes);
		
		for(int a=0; a<primes.length; a++)
		{
			if(primes[a])
			{
				if(isPandigital(String.valueOf(a)))
					lstPandigitalPrimes.add(a);			
			}
		}
		
		System.out.println("Total pandigitals primes found: " + lstPandigitalPrimes.size() + " under: " + ONE_MILLION);
		System.out.println("##########################");
		System.out.println("Max pandigital prime = " + Collections.max(lstPandigitalPrimes));
		System.out.println("##########################");

	}
	
	/* ################################################## */
	/* All utility methods go below. */
	/* ################################################## */

	public static boolean isPrime(int n) {
	    return primes[n]; 
	}

	/**
	 * Finds and returns if true if the number is pandigital
	 * @param strPan
	 * @return
	 */
	static boolean isPandigital(String strPan)
	{			
		int length = strPan.trim().length();
		
		boolean[] numerals = new boolean[length];
		Arrays.fill(numerals, false);
			
		int iPan = Integer.valueOf(strPan.trim());		
		int digit = 0;
		
		while(iPan > 0)
		{
			digit = iPan % 10;
			iPan /= 10;
			if(digit>0 && digit<=length)
				numerals[digit-1] = true;		
		}
		
		for(boolean pandigit : numerals)
		{
			//if an index i is 'false', it means that one of the 1-9 digits was not present in the string supplied to this method so return false
			if(!pandigit)
				return false;
		}
		
		//if it reaches this point, number is a pandigital. Check if its prime too,.,.				
		return true;
	}
}