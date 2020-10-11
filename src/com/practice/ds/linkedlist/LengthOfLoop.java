package com.practice.ds.linkedlist;

public class LengthOfLoop {

    private static int lengthOfLoop(ListNode head) {
        int length = 0;
        if (head == null || head.next == null) {
            return length;
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
        Now fast is inside the loop and we can store current
        node reference in temp variable and traverse through
        loop till we come to the same node and increment the
        length with each move
        */
        if (slow == fast) {
            ListNode startOfFast = fast;
            do {
                length++;
                fast = fast.next;
            } while (fast != startOfFast);
        }

        return length;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;
        System.out.println(lengthOfLoop(head));

        // 1, 4, 3
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        System.out.println(lengthOfLoop(head));
    }
}
