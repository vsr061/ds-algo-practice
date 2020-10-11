package com.practice.ds.linkedlist;

public class CircularListNode {

    /* Refer following implementation of ListNode from
    public class ListNode {
        //Current Node Value
        int val;
        //Next Node Reference
        ListNode next;

        //Empty Node Constructor
        public ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }*/

    /* Function to insert a ListNode
    at the beginning of a Circular
    linked list */
    static ListNode push(ListNode head_ref,
                         int data) {
        ListNode ptr1 = new ListNode();
        ListNode temp = head_ref;
        ptr1.val = data;
        ptr1.next = head_ref; 
  
        /* If linked list is not null
        then set the next of last ListNode */
        if (head_ref != null) {
            while (temp.next != head_ref)
                temp = temp.next;
            temp.next = ptr1;
        } else
            ptr1.next = ptr1;

        head_ref = ptr1;

        return head_ref;
    }
}
