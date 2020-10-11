package com.practice.ds.linkedlist;

public class RemoveLoop {

    private static ListNode removeLoop(ListNode head) {
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
        Also, we are detecting the end of the loop by checking
        slow.next != fast.next
        So, fast will be at the end of the loop
         */
        if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }

        return head;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head.next;
        ListNode currentNode = removeLoop(head);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }

        System.out.println();

        // 1, 4, 3
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        currentNode = removeLoop(head);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }
}
