package com.practice.ds.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

/*
    Problem link: https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class Problem_138_CloneRandomPointer {
    /*
        Here, this node struture has two pointers:
        next: points to the next node
        random: points to any node in the list
     */
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private static Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        Map<Node, Node> map = new LinkedHashMap<>();

        while (curr != null) {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }
        curr = head;

        while (curr != null) {
            Node node = map.get(curr);
            node.next = map.get(curr.next);
            node.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(curr);
    }

    public static void main(String[] args) {

    }
}
