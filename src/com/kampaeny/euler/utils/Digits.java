/**
 * Util class to work on digits
 */
package com.kampaeny.euler.utils;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Digits
{
	/**
	 * Find total number of digits
	 * @param value
	 * @return int
	 */
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
	
	
	/**
	 * Find total number of digits
	 * @param value
	 * @return int
	 */
	public static int numberOfDigits(BigDecimal value) 
	{
		System.out.println("#numberOfDigits(BigDecimal value): " + value);
		int digits = 0;
		
		while(value.compareTo(new BigDecimal(0)) > 0)
		{
			++digits;
//			System.out.println(value);
			value = value.divide(new BigDecimal(10));
//			System.out.println(value);
			
			if(value.compareTo(BigDecimal.TEN) < 0)
				System.out.println(value);
		}
		
		return digits;
	}

	
	/**
	 * Find digits on an integer
	 * @param value
	 * @return String[]
	 */
	public static int digitize(int value)
	{
		int digits = 0;
		
		while(value > 0)
		{
			++digits;
			value = value%10;
			System.out.println("digit = " + value);
			value /= 10;						
		}
		
		return digits;
	}
	
	/**
	 * Split into digits and find sum total of digits
	 * @return
	 */
	public static int splitIntoDigitsAndSum(int value)
	{
		String number = String.valueOf(value);	
		int sum = 0;
		
		for(int j = 0; j<number.length(); j++)
		{
		    int k = Character.digit(number.charAt(j), 10);
		    sum += k;
		}
		
		return sum;
	}
	
	/**
	 * Split into digits and find sum total of digits
	 * @return
	 */
	public static int splitIntoDigitsAndSum(long value)
	{
		String number = String.valueOf(value);	
		int sum = 0;
		
		for(int j = 0; j<number.length(); j++)
		{
		    int k = Character.digit(number.charAt(j), 10);
		    sum += k;
		}
		
		return sum;
	}
	
	/**
	 * Split into digits and find sum total of digits
	 * @return
	 */
	public static int splitIntoDigitsAndSum(BigInteger value)
	{
		String number = String.valueOf(value);	
		int sum = 0;
		
		for(int j = 0; j<number.length(); j++)
		{
		    int k = Character.digit(number.charAt(j), 10);
		    sum += k;
		}
		
		return sum;
	}

}
