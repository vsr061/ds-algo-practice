package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/reverse-linked-list/
 */
public class Problem_206_ReverseLinkedList {

    private static ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }

    private static ListNode reverseRecursive(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        ListNode restHead = reverseRecursive(head.next);
        ListNode restTail = head.next;
        restTail.next = head;
        head.next = null;

        return restHead;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode currentNode = reverse(head);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }

        System.out.println();

        // 1, 4, 3
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        currentNode = reverseRecursive(head);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }
}
