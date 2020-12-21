package com.practice.math;

public class Palindrome {

    private static int reverse(int no) {
        int reveredNo = 0;
        while (no != 0) {
            int digit = no % 10;
            reveredNo = reveredNo * 10 + digit;
            no = no / 10;
        }
        return reveredNo;
    }

    private static boolean isPalindrome(int no) {
        if (no < 0) return false;
        return no == reverse(no);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(784));
        System.out.println(isPalindrome(484));
    }
}
