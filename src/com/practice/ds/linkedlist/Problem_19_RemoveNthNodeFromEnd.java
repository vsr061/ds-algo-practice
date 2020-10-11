package com.practice.ds.linkedlist;


/*
    Problem link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class Problem_19_RemoveNthNodeFromEnd {

    private static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        if (head == null) {
            return null;
        }

        for (int i = 0; i < n; i++) {
            if (fastPointer != null) {
                fastPointer = fastPointer.next;
            } else {
                return null;
            }
        }

        if (fastPointer == null) {
            return head.next;
        }

        while (fastPointer.next != null) {
            fastPointer = fastPointer.next;
            slowPointer = slowPointer.next;
        }

        slowPointer.next = slowPointer.next.next;
        return head;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode currentNode = removeNthFromEnd(head, 2);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }

        System.out.println();

        // 1, 4
        head.next = null;
        currentNode = removeNthFromEnd(head, 1);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }
}
