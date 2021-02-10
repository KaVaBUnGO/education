package com.arturchernov.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 138. Copy List with Random Pointer
 * <p>
 * A linked list of length n is given such that each node contains an additional random pointer,
 * which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 * where each new node has its value set to the value of its corresponding original node.
 * Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the
 * pointers in the original list and copied list represent the same list state. None of the pointers in the
 * new list should point to nodes in the original list.
 */
public class LeetCode138 {

    public static void main(String[] args) {
        Node first = new Node(1);
        Node second = new Node(2);
        first.next = second;
        first.random = second;
        second.random = second;
        Node ans = copyRandomList(first);
        Node temp = first;
        while (temp != null) {
            System.out.print(temp.hashCode() + " ");
            temp = temp.next;
        }
        System.out.println();
        temp = ans;
        while (temp != null) {
            System.out.print(temp.hashCode() + " ");
            temp = temp.next;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node newNode = map.get(temp);
            newNode.next = map.get(temp.next);
            newNode.random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}