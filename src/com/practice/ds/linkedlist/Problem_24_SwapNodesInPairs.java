package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Problem_24_SwapNodesInPairs {

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode curr = head.next.next;
        ListNode prev = head;
        head = head.next;
        head.next = prev;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            ListNode next = curr.next.next;
            curr.next.next = curr;
            curr = next;

        }
        prev.next = curr;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode currentNode = swapPairs(head);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }
}
