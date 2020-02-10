/*
A number chain is created by continuously adding the square of the digits in a number to form a new number until it has been seen before.

For example,

44 -> 32 -> 13 -> 10 -> 1 -> 1
85 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 -> 58 -> 89

Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. 
What is most amazing is that EVERY starting number will eventually arrive at 1 or 89.

How many starting numbers below ten million will arrive at 89?
*/
package com.kampaeny.euler.solved;

import java.util.ArrayList;

public class Problem092 
{
	public static void main(String[] args) 
	{
		int maxNum = 10000000; //10 million
		int sum = 0, countFor89 = 0;
		boolean go1 = false, go2 = false;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		
		for(int i=2; i<=maxNum; i++)
		{
			if(counter89(i, sum, countFor89, go1, go2)==1)
			{ numbers.add(1); }
		}		
		
		System.out.println("Total numbers ending at 89 = " + numbers.size());
	}

	private static int counter89(int maxNum, int sum, int countFor89, boolean go1, boolean go2) 
	{
		while(!go1)
		{
			sum = (sum==0)?digitizeAndPower(maxNum):digitizeAndPower(sum);
			
			if(sum==1)
			{ break; }
			
			if(sum == 89)
			{ go1 = true; }
		}
		
		while(!go2)
		{
			sum = digitizeAndPower(sum);
			
			if(sum==1)
			{ break; }
			
			if(sum == 89)
			{ go2 = true; }
			
			if(go1 && go2)
			{ 
				countFor89++;
				sum = 0;
			}
		}
		
		return countFor89;
	}

	private static int digitizeAndPower(int valueToParse) 
	{
		String number = String.valueOf(valueToParse);	
		int sum = 0;
		
		for(int j = 0; j<number.length(); j++)
		{
		    int k = Character.digit(number.charAt(j), 10);
		    sum += Math.pow(k, 2);
		}
		
		return sum;
	}
}
