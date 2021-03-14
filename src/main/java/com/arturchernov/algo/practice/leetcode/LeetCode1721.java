package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1721. Swapping Nodes in a Linked List
 * <p>
 * You are given the head of a linked list, and an integer k.
 * <p>
 * Return the head of the linked list after swapping the values of the kth node from the beginning
 * and the kth node from the end (the list is 1-indexed).
 */
public class LeetCode1721 {

    public static void main(String[] args) {
        print(swapNodes(build(new int[]{1, 2, 3}), 1));
        print(swapNodes(build(new int[]{1, 2, 3, 4, 5}), 2));
        print(swapNodes(build(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}), 5));
        print(swapNodes(build(new int[]{7, 9, 6, 6, 7, 8, 3, 0, 9, 5}), 6));
        print(swapNodes(build(new int[]{1}), 1));
        print(swapNodes(build(new int[]{1, 2}), 1));
        print(swapNodes(build(new int[]{1, 2, 3}), 2));
        print(swapNodes(build(new int[]{1, 2, 3, 4}), 1));
        print(swapNodes(build(new int[]{1, 2, 3, 4}), 4));
    }

    private static ListNode build(int[] a) {
        ListNode head = new ListNode(a[0]);
        ListNode last = head;
        for (int i = 1; i < a.length; i++) {
            last.next = new ListNode(a[i]);
            last = last.next;
        }
        return head;
    }

    private static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode swapNodes(ListNode head, int k) {
        List<ListNode> ar = new ArrayList<>();
        ListNode t = head;
        while (t != null) {
            ar.add(t);
            t = t.next;
        }
        int l = k - 1, r = ar.size() - k;
        if (l == r || ar.size() == 1) {
            return head;
        }
        if (l > r) {
            head = swap(ar, r, l, head);
        } else {
            head = swap(ar, l, r, head);
        }
        return head;
    }

    private static ListNode swap(List<ListNode> ar, int l, int r, ListNode head) {
        if (ar.size() == 2) {
            ar.get(l).next = null;
            ar.get(r).next = ar.get(l);
            ar.set(l, ar.get(r));
        } else if (r - l == 1) {
            ar.get(l - 1).next = ar.get(r);
            ar.get(r).next = ar.get(l);
            ar.get(l).next = ar.get(r + 1);
        } else if (l != 0) {
            ar.get(l - 1).next = ar.get(r);
            ar.get(r).next = ar.get(l).next;
            ar.get(r - 1).next = ar.get(l);
            ar.get(l).next = ar.get(r + 1);
        } else {
            ar.get(r - 1).next = ar.get(l);
            ar.get(l).next = null;
            ar.get(r).next = ar.get(l + 1);
            ar.set(l, ar.get(r));
        }
        return ar.get(0);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return String.valueOf(this.val);
        }
    }
}