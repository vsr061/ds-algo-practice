package com.practice.math;

public class Factorial {

    private static int factorial(int no) {
        int factorial = 1;
        for (int i = 1; i <= no; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorial(15));
    }
}
