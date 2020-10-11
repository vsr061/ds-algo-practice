package com.practice.ds.linkedlist;

public class PartitionList {

        private static ListNode partition(ListNode head, int x) {
            ListNode temp = head;

            while(temp != null) {
                if(temp.val == x) {
                    break;
                }
                temp = temp.next;
            }

            ListNode dummyList = new ListNode(-1);
            ListNode dummyHead = dummyList;
            System.out.println(temp.val + ", ");
            ListNode prevNode = temp;
            while(temp != null) {
                if(temp.val < x) {
                    //System.out.print(dummyList.val + ", ");
                    dummyList.next = new ListNode(temp.val);
                    dummyList = dummyList.next;
                }
                temp = temp.next;
            }

            while (dummyHead != null) {
                System.out.println(dummyHead.val + ", ");
                dummyHead = dummyHead.next;
            }

            return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode currenNode = partition(head, 3);
//        while (currenNode != null) {
//            System.out.print(currenNode.val + ", ");
//            currenNode = currenNode.next;
//        }
    }
}
