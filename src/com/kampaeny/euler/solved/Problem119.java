/*
The number 512 is interesting because it is equal to the sum of its digits raised to some power: 5 + 1 + 2 = 8, and 8^3 = 512.
Another example of a number with this property is 614656 = 28^4.
We shall define avn to be the nth term of this sequence and insist that a number must contain at least two digits to have a sum.
You are given that av2 = 512 and av10 = 614656.
Find a30.
Stole the coding logic for this problem from Internet.
*/
package com.kampaeny.euler.solved;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.kampaeny.euler.tools.Audit;
import com.kampaeny.euler.tools.NumberTools;

public class Problem119 {

    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();
        List<BigInteger> indices = new ArrayList<>();
        // initialize variables
        BigInteger b = new BigInteger("2");
        BigInteger e = new BigInteger("2");
        BigInteger max = new BigInteger("400");
        BigInteger maxList = new BigInteger("50");
        for (; b.compareTo(max) < 0; b = b.add(BigInteger.ONE)) {
            BigInteger value = b;
            e = new BigInteger("2");
            for (; e.compareTo(maxList) < 0; e = e.add(BigInteger.ONE)) {
                value = value.multiply(b);
                if (b.compareTo(new BigInteger(String.valueOf(NumberTools.splitIntoDigitsAndSum(value)))) == 0) {
                    indices.add(value);
                }
                if (indices.size() > 50) {
                    break;
                }
            }
            if (indices.size() > 50) {
                break;
            }
        }
        // sort
        Collections.sort(indices);
        System.out.println("####################");
        System.out.println("Size: " + indices.size());
        System.out.println(indices);
        System.out.println(indices.get(2 - 1) + ", " + indices.get(10 - 1) + ", " + indices.get(30 - 1));
        System.out.println("####################");
        System.out.println("Total Time Taken: " + (Audit.timeTaken(startTime, System.currentTimeMillis()) / 1000));
    }

}
