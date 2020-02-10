/*
The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left: 3797, 379, 37, and 3.

Find the sum of the only eleven primes that are both truncatable from left to right and right to left.

NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
*/
package com.kampaeny.euler.solved;

import java.util.ArrayList;
import java.util.List;

import com.kampaeny.euler.utils.Digits;
import com.kampaeny.euler.utils.PrimeSieve;

public class Problem037 
{
	static final int ONE_MILLION = 1000000;
	static boolean[] primes = new boolean[ONE_MILLION]; 
	
	public static void main(String[] args) 
	{	
		int primeSum = 0;
		List<Integer> truncPrimeList = new ArrayList<Integer>();
		
		//construct the prime array
		primes = PrimeSieve.fillSieve(primes);
		
		for(int i=8; i<primes.length; i++)
		{
			if(isTruncatablePrime(i))
			{ truncPrimeList.add(i); }
		}
		
		for(int j=0; j<11; j++)
		{ primeSum = primeSum + truncPrimeList.get(j); }
		
		System.out.println("####################");
		System.out.println("Final Sum = " + primeSum);
		System.out.println("####################");
	}

	private static boolean isTruncatablePrime(int t)
	{
		boolean bTruncatablePrime = false;
		int root = 10;
//		int power = numberOfDigits(t);
		int power = Digits.numberOfDigits(t);
			
		if(isPrime(t))
		{			
			//left-to-right
//			bTruncatablePrime = (isPrime(t%10)) ? ((isPrime(t%100)) ? (isPrime(t%1000)?true:false) : false ) : false;
			bTruncatablePrime = isPrime(t%root);
			
			for(int i=1; i<power; i++)
			{
				if(bTruncatablePrime)
				{ bTruncatablePrime = isPrime(t%((int)Math.pow(root, i))); }					
				else
					break; //if one of the value is false, dont bother to calculate others
			}
						
			//right-to-left. proceed only if master value is prime and left-to-right is prime
			if(bTruncatablePrime)
			{ 
//				bTruncatablePrime = (isPrime(t/10)) ? ((isPrime(t/100)) ? (isPrime(t/1000)?true:false) : false ) : false;
				
				for(int i=1; i<power; i++)
				{
					if(bTruncatablePrime)
					{ bTruncatablePrime = isPrime(t/((int)Math.pow(root, i))); }
					else
						break; //if one of the value is false, dont bother to calculate others
				}
			}
						
			//if 'b' is still true, it is a truncatable prime
			if(bTruncatablePrime)
				System.out.println("### Truncatable Prime ### = " + t);
		}
		
		return bTruncatablePrime;
	}
	
	public static boolean isPrime(int n) {
	    return primes[n]; 
	}
	
	/* ################################################## */
	/* All utility methods go below. */
	/* ################################################## */	
	public static int numberOfDigits(int value)
	{
		int digits = 0;
		
		while(value > 0)
		{
			++digits;
			value /= 10;
		}
		
		return digits;
	}
}
