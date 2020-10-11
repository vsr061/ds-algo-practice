package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/intersection-of-two-linked-lists
 */
public class Problem_160_IntersectionOfTwoList {

    private static int length(ListNode head) {
        int length = 0;
        for (ListNode curr = head; curr != null; curr = curr.next, length++) ;
        return length;
    }

    private static ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        int length1 = length(head1);
        int length2 = length(head2);
        int diff = Math.abs(length1 - length2);

        if (length1 > length2) {
            for (int i = diff; i > 0; head1 = head1.next, i--) ;
        } else {
            for (int i = diff; i > 0; head2 = head2.next, i--) ;
        }

        /*
            So, now both the list have same no. of nodes to traverse
            and current head pointer are on same distance from the intersection.
            So, traverse each list till both pointers meet at the same point
         */
        for (; head1 != head2; head1 = head1.next, head2 = head2.next) ;

        return head1;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(2);
        head1.next.next.next.next = new ListNode(5);

        // 1, 2, 3
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);

        System.out.println(getIntersectionNode(head1, head2) != null
                ? getIntersectionNode(head1, head2).val
                : getIntersectionNode(head1, head2));

        // 1, 2, 3, 2, 5
        head2.next.next = head1.next.next;

        System.out.println(getIntersectionNode(head1, head2) != null
                ? getIntersectionNode(head1, head2).val
                : getIntersectionNode(head1, head2));

    }
}
