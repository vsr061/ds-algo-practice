package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/delete-node-in-a-linked-list/
 */
public class Problem_237_DeleteNode {

    private static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        deleteNode(head.next);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }

        System.out.println();

        // 1, 1, 1
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        deleteNode(head.next);
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}
