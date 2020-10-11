package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/odd-even-linked-list/
 */
public class Problem_328_EvenOddNodes {

    private static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode oddList = head;
        ListNode evenList = head.next;

        ListNode dummyHead = evenList;

        while (evenList != null && evenList.next != null) {
            oddList.next = evenList.next;
            oddList = oddList.next;
            evenList.next = oddList.next;
            evenList = evenList.next;
        }

        oddList.next = dummyHead;

        return head;
    }

    public static void main(String[] args) {
        // 1, 2, 3, 4, 5, 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode currentNode = oddEvenList(head);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }

        System.out.println();

        // 1, 2, 3
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        currentNode = oddEvenList(head);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }
}
