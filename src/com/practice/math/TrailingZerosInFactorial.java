package com.practice.math;

public class TrailingZerosInFactorial {

    private static int trailingZeroes(int n) {
        int trailingZeros = 0;
        for (int powerOf5 = 5; n / powerOf5 != 0; powerOf5 *= 5) {
            trailingZeros += n / powerOf5;
        }
        return trailingZeros;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
        System.out.println(trailingZeroes(20));
    }
}
