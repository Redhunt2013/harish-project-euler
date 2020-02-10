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

import com.kampaeny.euler.utils.PrimeSieve;

public class Problem050 
{
	static int MAX_VALUE = 1000000; //1000000
	static boolean[] primes = new boolean[MAX_VALUE];
	static List<Integer> primeNumbersList = new ArrayList<Integer>();  

	public static void main(String[] args) 
	{ 
		primes = PrimeSieve.fillSieve(primes);
		
		for(int a=0; a<primes.length; a++)
		{
			if(primes[a])
				primeNumbersList.add(a);
		}
		
		System.out.println(primeNumbersList);	
		
		int totalPrimesUnderMax = primeNumbersList.size();		
		int tempSum = 0, tempSum2 = 0;		
		int innerBound = 0, outerBound = totalPrimesUnderMax-1;
		int maxTerms1 = 0, maxTerms2 = 0;
		
		while (innerBound<=outerBound) 
		{
			tempSum = 0;
			maxTerms1 = 0;
					
			for (int i=innerBound; i<=outerBound; i++)
			{
				tempSum += primeNumbersList.get(i);
				
				++maxTerms1;

				if(tempSum>primeNumbersList.get(outerBound))
				{ break; }
				else if(primeNumbersList.contains(tempSum))
				{
					if(maxTerms2<maxTerms1)
					{
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
