package com.practice.ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

/*
    Problem link: https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */
public class Problem_1171_RemoveZeroSumConsecutive {

    private static ListNode removeZeroSumSublist(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode current = head;
        int sum = 0;

        if (head == null) return null;

        while (current != null) {
            sum += current.val;
            map.put(sum, current);
            current = current.next;
        }

        current = head;
        sum = 0;
        while (current != null) {
            sum += current.val;
            if (sum == 0) {
                head = current.next;
            } else if (map.containsKey(sum)) {
                current.next = map.get(sum).next;
            }
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        // 3, 4, -7, 3, 1, 3, 1, -4, -2, -2
        ListNode head = new ListNode(3);
        head.next = new ListNode(4);
        head.next.next = new ListNode(-7);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next.next = new ListNode(-4);
        head.next.next.next.next.next.next.next.next = new ListNode(-2);
        head.next.next.next.next.next.next.next.next.next = new ListNode(-2);
        ListNode currentNode = removeZeroSumSublist(head);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }

        System.out.println();

        // 1, 4, 3, -7, 5
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(-7);
        head2.next.next.next.next = new ListNode(5);
        currentNode = removeZeroSumSublist(head2);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }


}
