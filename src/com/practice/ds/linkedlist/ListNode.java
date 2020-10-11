package com.practice.ds.linkedlist;

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
}
