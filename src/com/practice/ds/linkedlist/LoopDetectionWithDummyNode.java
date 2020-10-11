package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LoopDetectionWithDummyNode {

    private static ListNode detectLoop(ListNode head) {
        ListNode loopStart = null;

        ListNode dummyNode = new ListNode(-1);
        ListNode next;
        
        while (head != null) {
            next = head.next;
            if (next == null) {
                break;
            } else if (next == dummyNode) {
                loopStart = head;
                break;
            } else {
                head.next = dummyNode;
            }
            head = next;
        }

        return loopStart;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next.next;
        System.out.println(detectLoop(head).val);

        // 1, 4, 3
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        System.out.println(detectLoop(head));
    }
}
