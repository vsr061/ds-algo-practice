package com.practice.ds.linkedlist;

public class MergeTwoSortedLists {

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        ListNode list2 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        ListNode currenNode = mergeTwoLists(list1, list2);
        while (currenNode != null) {
            System.out.print(currenNode.val + ", ");
            currenNode = currenNode.next;
        }
    }
}
