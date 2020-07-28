package com.practice.algo;

import com.practice.ds.linkedlist.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LongestNonRepetitiveSubString {

    private static int stringLength(String s) {
        int first_pointer = 0;
        int second_pointer = 0, max = 0;
        HashSet<Character> hash = new HashSet<>();
        while (second_pointer < s.length()) {
            if (!hash.contains(s.charAt(second_pointer))) {
                hash.add(s.charAt(second_pointer));
                second_pointer++;
                max = Math.max(hash.size(), max);
            } else {
                hash.remove(s.charAt(first_pointer));
                first_pointer++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Length: " + stringLength("aab"));
        System.out.println("Length: " + stringLength("aabbbc"));
        System.out.println("Length: " + stringLength("aabc"));
    }


}
