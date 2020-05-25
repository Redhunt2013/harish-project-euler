/*
 * Find the unique positive integer whose square has the form 1_2_3_4_5_6_7_8_9_0,
where each "_" is a single digit.
 */
package com.kampaeny.euler.solving;

import java.math.BigDecimal;

import com.kampaeny.euler.tools.NumberTools;

public class Problem206
{
	public static void main(String[] args)
	{
		BigDecimal sq = new BigDecimal(Math.pow(1000000.0, 2.0));
		System.out.println((sq.compareTo(new BigDecimal(0))>0));
		System.out.println(NumberTools.numberOfDigits(sq));
	}
}
