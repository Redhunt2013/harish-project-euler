package com.kampaeny.euler.solved;

public class Problem023 {
    public static void main(String[] args) {
        int limit = 28123;
        boolean[] isAbundant = new boolean[limit + 1];
        boolean[] isSumOfAbundant = new boolean[limit + 1];
        long sum = 0;

        // Compute abundant numbers
        for (int i = 12; i <= limit; i++) {
            if (sumOfProperDivisors(i) > i) {
                isAbundant[i] = true;
            }
        }

        // Mark all numbers that can be written as the sum of two abundant numbers
        for (int i = 12; i <= limit; i++) {
            for (int j = 12; j <= limit - i; j++) {
                if (isAbundant[i] && isAbundant[j]) {
                    isSumOfAbundant[i + j] = true;
                }
            }
        }

        // Add up all numbers that cannot be written as the sum of two abundant numbers
        for (int i = 1; i <= limit; i++) {
            if (!isSumOfAbundant[i]) {
                sum += i;
            }
        }

        System.out.println(sum);
    }

    private static int sumOfProperDivisors(int n) {
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sum += i;
                if (i != n / i) {
                    sum += n / i;
                }
            }
        }
        return sum;
    }
}
