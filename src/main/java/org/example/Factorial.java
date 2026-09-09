package org.example;

public class Factorial {

    public static long calculate(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be non-negative");
        }

        long result = 1;

        for (int i = 2; i <= n; i++) {
            result = Math.multiplyExact(result, i);
        }

        return result;
    }
}