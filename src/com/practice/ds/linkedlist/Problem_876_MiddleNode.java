package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class Problem_876_MiddleNode {

    private static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println(middleNode(head).val);

        // 1, 4
        head.next.next = null;

        System.out.println(middleNode(head).val);
    }
}
