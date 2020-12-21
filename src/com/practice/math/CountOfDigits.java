package com.practice.math;

public class CountOfDigits {

    private static int countOfDigits(int no) {
        return (int) Math.floor(Math.log10(no) + 1);
    }

    private static int countOfDigitsString(int no) {
        return String.valueOf(no).length();
    }

    public static void main(String[] args) {
        System.out.println(countOfDigits(885));
        System.out.println(countOfDigits(785));
        System.out.println(countOfDigitsString(885));
        System.out.println(countOfDigitsString(785));
    }
}
