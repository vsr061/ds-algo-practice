package com.practice.ds.linkedlist;

public class SegregateEvenOddNodeValues {

    private static ListNode oddEvenList(ListNode head) {
        ListNode oddList = new ListNode(-1);
        ListNode evenList = new ListNode(-1);
        ListNode evenListHead = evenList;
        ListNode oddListHead = oddList;

        for (int i = 1; head != null; head = head.next) {
            if (head.val % 2 == 0) {
                evenList.next = head;
                evenList = evenList.next;
            } else {
                oddList.next = head;
                oddList = oddList.next;
            }
        }

        evenList.next = oddListHead.next;
        oddList.next = null;

        return evenListHead.next;
    }

    public static void main(String[] args) {
        // 1, 2, 6, 4, 5, 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
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
