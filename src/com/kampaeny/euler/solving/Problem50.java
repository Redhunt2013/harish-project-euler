/*
The prime 41, can be written as the sum of six consecutive primes:
41 = 2 + 3 + 5 + 7 + 11 + 13

This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?  
*/
package com.kampaeny.euler.solving;

import java.util.ArrayList;
import java.util.List;

import com.kampaeny.euler.utils.PrimeSieve;

public class Problem50 {
	static int MAX_VALUE = 1000;
	static boolean[] primes = new boolean[MAX_VALUE];
	static List<Integer> primeNumbersList = new ArrayList<Integer>();  
	
	public static void main(String[] args) {
		primes = PrimeSieve.fillSieve(primes);
				
		for(int a=0; a<primes.length; a++)
		{
			if(primes[a])
				primeNumbersList.add(a);
		}
		
		int totalIndicesUnderMax = primeNumbersList.size()-1;
		int innerIndex, outerIndex;
		innerIndex = outerIndex = 0;
		int sum = 0;
		int maxSum = 0;
		int totalTermsForMaxSum = 0;
		boolean increment = false;
		
		System.out.println(primeNumbersList.get(totalIndicesUnderMax));
		
		while(totalIndicesUnderMax > innerIndex)
		{	
			if(increment)
			{
				System.out.println("go ahead");
				++innerIndex;
			}
			
			System.out.println("Current index is = " + innerIndex);
			System.out.println("Current last index is = " + totalIndicesUnderMax);
			
			while(innerIndex<=totalIndicesUnderMax)
			{
				System.out.println("index["+innerIndex+"] = " + primeNumbersList.get(innerIndex));
				sum += primeNumbersList.get(innerIndex);
				++innerIndex;
				
				if(sum==primeNumbersList.get(totalIndicesUnderMax))
				{
					System.out.println("Total Consecutive Terms = " + innerIndex + ", with sum = " + sum);
					
					if(sum > maxSum)
					{
						System.out.println("sum is greater than max sum");
						maxSum = sum;
						totalTermsForMaxSum = innerIndex;
						break;
					}
					else
						System.out.println("sum is NOT greater than max sum: " + sum + ", " + maxSum);
					
					sum = 0;
					increment =false;
					
					break;
				}
				else if(sum>primeNumbersList.get(totalIndicesUnderMax))
				{
					System.out.println("Sum EXCEEDS last value in list");
					sum = 0;
					increment = true;
					break;
				}
//				else if(sum<primeNumbersList.get(totalIndicesUnderMax))
//					System.out.println("Sum is LESS than predecessors");
			}
			
			--totalIndicesUnderMax;
			innerIndex = sum = 0;
		}		
						
		System.out.println("Total primes under " + MAX_VALUE + " is : <" + primeNumbersList.size() + ">");
		System.out.println(primeNumbersList);
		System.out.println("Sum of max consecutive primes = " + maxSum + " with " + totalTermsForMaxSum + " terms!!!");
	}
}
