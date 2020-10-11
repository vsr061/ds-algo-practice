package com.practice.ds.linkedlist;

import java.util.LinkedList;

public class GKG_Course_Problem {

    public static class ListNode<E> {
        //Current Node Value
        E val;
        //Next Node Reference
        ListNode<E> next;

        //Empty Node Constructor
        public ListNode() {
        }

        ListNode(E val) {
            this.val = val;
        }

        ListNode(E val, ListNode<E> next) {
            this.val = val;
            this.next = next;
        }
    }

    private static String replaceAll(String input, char key) {
        ListNode<Character> replacedList = new ListNode<>();
        ListNode<Character> replacedListHead = replacedList;

        LinkedList<String> list =  new LinkedList<>();
        for (char c : input.toCharArray()) {
            if (c == key) {
                replacedList.next = new ListNode<>('y');
                replacedList.next.next = new ListNode<>('y');
                replacedList.next.next.next = new ListNode<>('y');
                replacedList = replacedList.next.next;
            } else {
                replacedList.next = new ListNode<>(c);
            }
            replacedList = replacedList.next;
        }

        replacedListHead = replacedListHead.next;
        StringBuilder replacedString = new StringBuilder();
        while (replacedListHead != null) {
            replacedString.append(replacedListHead.val);
            replacedListHead = replacedListHead.next;
        }

        return replacedString.toString();
    }

    public static void main(String[] args) {
        System.out.println(replaceAll("Abcsdxudxscsdcsd", 'x'));
        System.out.println(replaceAll("Abcsdxudxscsdscsd", 's'));
    }
}
