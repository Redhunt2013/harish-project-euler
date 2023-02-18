package com.kampaeny.euler.solved;

public class Problem015 {
    public static void main(String[] args) {
        int n = 20;
        long routes = binomialCoefficient(2 * n, n);
        System.out.println(routes);
    }

    private static long binomialCoefficient(int n, int k) {
        if (k > n - k) {
            k = n - k;
        }
        long result = 1;
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }
        return result;
    }
}
