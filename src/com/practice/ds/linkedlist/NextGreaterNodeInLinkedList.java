package com.practice.ds.linkedlist;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {

    private static int[] nextLargerNodes(ListNode head) {
        ListNode temp = head;
        int listSize = 0;
        while (temp != null) {
            listSize++;
            temp = temp.next;
        }

        temp = head;
        int[] result = new int[listSize];

        Stack<Integer> stack = new Stack();
        for (int i = 0; temp != null; i++) {
            ListNode current = temp;
            if (!stack.isEmpty()) {
                if (current.val < stack.peek()) {
                    result[i] = stack.peek();
                }
            }
            temp = temp.next;
        }

        return result;
    }

    public static void main(String[] args) {
        // 2,7,4,3,5
        ListNode head = new ListNode(2);
        head.next = new ListNode(7);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);

        int[] result = nextLargerNodes(head);

        System.out.println(Arrays.toString(result));
    }
}
