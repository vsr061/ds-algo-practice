package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/remove-linked-list-elements/submissions/
 */
public class Problem_203_RemoveNodeWithVal {

    private static ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        /*
            If
                head's and next consecutive nodes' values are equal to the target value
            then
                shift head to the node whose value is not equal to the target
         */
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head != null) {
            ListNode prev = head;
            ListNode curr = prev.next;

            while (curr != null) {
                if (curr.val == val) {
                    prev.next = curr.next;
                    curr = curr.next;
                    //Don't change prev pointer position
                    continue;
                }
                prev = prev.next;
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode currentNode = removeElements(head, 2);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }

        System.out.println();

        // 1, 1, 1
        head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);

        currentNode = removeElements(head, 1);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }
}
