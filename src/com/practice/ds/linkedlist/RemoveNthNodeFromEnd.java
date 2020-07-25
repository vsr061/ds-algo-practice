package com.practice.ds.linkedlist;

public class RemoveNthNodeFromEnd {

    private static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode slowPointer = head;
        ListNode fastPointer = head;
        int index = 1;

        if (head.next == null && n == 1) {
            return null;
        }


        for (int i = 0; i < n; i++) {
            fastPointer = fastPointer.next;
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
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        ListNode currenNode = removeNthFromEnd(head, 2);
        while (currenNode != null) {
            System.out.print(currenNode.val + ", ");
            currenNode = currenNode.next;
        }
    }
}
