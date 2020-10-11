package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/linked-list-cycle/
 */
public class Problem_141_LoopDetection1 {

    private static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        boolean hasLoop = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasLoop = true;
                break;
            }
        }
        return hasLoop;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;
        System.out.println(hasCycle(head));

        // 1, 4, 3
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        System.out.println(hasCycle(head));
    }
}
