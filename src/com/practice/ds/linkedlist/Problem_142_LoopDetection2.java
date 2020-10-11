package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class Problem_142_LoopDetection2 {

    private static ListNode detectCycle(ListNode head) {
        ListNode loopStart = null;
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        //Detect Loop
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        /*
        As slow and fast pointers can collide with each other
        at any node in the loop, we need to set slow to start
        of the list and move both one by one
         */
        if (slow == fast) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            loopStart = slow;
        }

        return loopStart;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;
        System.out.println(detectCycle(head).val);

        // 1, 4, 3
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        System.out.println(detectCycle(head));
    }
}
