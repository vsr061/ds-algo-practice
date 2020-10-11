package com.practice.ds.linkedlist;

public class GKG_Course_DeleteGivenNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        // 1, 4, 3, 2, 5, 2
        ListNode nodeToDelete = head.next.next.next.next; //5
        nodeToDelete.val = nodeToDelete.next.val;
        nodeToDelete.next = nodeToDelete.next.next;
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}
