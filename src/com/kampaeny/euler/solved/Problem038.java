/*
Problem# 38:
============
Take the number 192 and multiply it by each of 1, 2, and 3:

    192 × 1 = 192
    192 × 2 = 384
    192 × 3 = 576

By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)

The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).

What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer with (1,2, ... , n) where n > 1?
 */
package com.kampaeny.euler.solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem038 
{
	static final int MAX_DIGIT = 9;
	static final int ONE_MILLION = 1000000;
	
	public static void main(String[] args) 
	{
		int multiplicand = ONE_MILLION; // 5 X 7; "7" is the multiplicand
		int multiplier = ONE_MILLION; // 5 X 7; "5" is the multiplier
		String concat = null;
		boolean bPanDigital = false;
		List<String> lstPandigitals = new ArrayList<String>();
		
		for(int i=1; i<=multiplier; i++)
		{
			if(concat == null) concat = "";
			
			for(int j=1; j<=multiplicand; j++)
			{
				concat = concat + String.valueOf((i*j));
				
				if(concat.length() > MAX_DIGIT)
				{
					concat = "";
					break;
				}
				else
				{					
					if(concat.length() == 9)
					{
						bPanDigital = isPandigital(concat);
						
						if(bPanDigital) 
						{ lstPandigitals.add(concat); }
					}
				}				
			}
			
			concat="";
		}

		System.out.println("Total pandigitals found: " + lstPandigitals.size());
		System.out.println(lstPandigitals);
		
		System.out.println("##########################");
		System.out.println("Max pandigital = " + Collections.max(lstPandigitals));
		System.out.println("##########################");
	}
	
	static boolean isPandigital(String strPan)
	{
		//if the string is more than 9 in length, dont bother to proceed further since it is not going to 1-9 pandigital
		if(strPan.length() > MAX_DIGIT || strPan.length() < MAX_DIGIT)
			return false;			
			
		boolean[] numerals = new boolean[MAX_DIGIT];
		Arrays.fill(numerals, false);
			
		int iPan = Integer.valueOf(strPan.trim());		
		int digit = 0;
		
		while(iPan > 0)
		{
			digit = iPan % 10;
			iPan /= 10;
			if(digit>0)
				numerals[digit-1] = true;			
		}
		
		for(boolean pandigit : numerals)
		{
			//if an index i is 'false', it means that one of the 1-9 digits was not present in the string supplied to this method so return false
			if(!pandigit)
				return false;
		}

		return true;		
	}
}
