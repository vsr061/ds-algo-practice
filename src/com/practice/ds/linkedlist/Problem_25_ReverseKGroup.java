package com.practice.ds.linkedlist;

/*
    Problem link: https://leetcode.com/problems/reverse-nodes-in-k-group
 */
public class Problem_25_ReverseKGroup {

    private static int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    //Recursive Solution:
    private static ListNode reverseKGroupRecursive(ListNode head, int k) {

        /* Its a special condition for LeetCode problem
           If ( length of list < k)
           then don't reverse
         */
        if (k == 0 || k > length(head)) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        //Reverse the list till k
        for (int i = 1; curr != null && i <= k; i++) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        /* reverse remaining sub-lists with recursion
           and
           append after head as it will be a ew tail after reversal
         */
        if (curr != null) {
            head.next = reverseKGroupRecursive(curr, k);
        }

        //prev will be new head after reversal
        return prev;
    }

    private static ListNode reverse(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode curr = last.next;

        while (curr != next) {
            last.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
            curr = last.next;
        }

        return last;
    }

    //Iterative Solution:
    private static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        int i = 0;

        ListNode p = head;
        while (p != null) {
            i++;
            if (i % k == 0) {
                pre = reverse(pre, p.next);
                p = pre.next;
            } else {
                p = p.next;
            }
        }

        return fake.next;
    }

    public static void main(String[] args) {
        // 1, 4, 3, 2, 5, 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode currentNode = reverseKGroupRecursive(head, 4);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }

        System.out.println();

        // 1, 4, 3
        head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        currentNode = reverseKGroup(head, 2);
        while (currentNode != null) {
            System.out.print(currentNode.val + ", ");
            currentNode = currentNode.next;
        }
    }
}
