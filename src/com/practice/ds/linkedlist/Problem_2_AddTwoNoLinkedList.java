package com.practice.ds.linkedlist;

public class Problem_2_AddTwoNoLinkedList {
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;
        int sum, carry = 0;

        while (l1 != null || l2 != null) {

            int firstNo = l1 != null ? l1.val : 0;
            int secondNo = l2 != null ? l2.val : 0;

            sum = firstNo + secondNo + carry;
            currentNode.next = new ListNode(sum % 10);
            carry = sum / 10;

            currentNode = currentNode.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry > 0) {
            currentNode.next = new ListNode(carry);
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        ListNode currentNode = addTwoNumbers(head, head);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }
}
