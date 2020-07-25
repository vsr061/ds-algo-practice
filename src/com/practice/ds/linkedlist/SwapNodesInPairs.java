package com.practice.ds.linkedlist;

public class SwapNodesInPairs {

    private static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //a fake head
        ListNode h = new ListNode(0);
        h.next = head;

        ListNode p1 = head;
        ListNode p2 = head.next;

        ListNode pre = h;
        while (p1 != null && p2 != null) {
            pre.next = p2;

            ListNode t = p2.next;
            p2.next = p1;
            pre = p1;
            p1.next = t;

            p1 = p1.next;

            if (t != null)
                p2 = t.next;
        }

        return h.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));
        ListNode currenNode = swapPairs(head);
        while (currenNode != null) {
            System.out.print(currenNode.val + ", ");
            currenNode = currenNode.next;
        }
    }
}
