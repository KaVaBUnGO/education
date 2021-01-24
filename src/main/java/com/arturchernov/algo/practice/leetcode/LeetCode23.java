package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 23.Merge k Sorted Lists
 * <p>
 * You are given an array of k linked-lists lists,each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 */

public class LeetCode23 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode3 = new ListNode(-10_000, new ListNode(10_000));
        ListNode res1 = mergeKLists(new ListNode[]{listNode, listNode2, listNode3});
        while (res1 != null) {
            System.out.print(res1.val + " ");
            res1 = res1.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode[] heads = new ListNode[2 * 10_000 + 1];
        ListNode[] tails = new ListNode[2 * 10_000 + 1];
        for (ListNode node : lists) {
            while (node != null) {
                ListNode next = node.next;
                if (heads[node.val + 10_000] == null) {
                    node.next = null;
                    heads[node.val + 10_000] = node;
                    tails[node.val + 10_000] = heads[node.val + 10_000];
                } else {
                    node.next = heads[node.val + 10_000];
                    heads[node.val + 10_000] = node;
                }
                node = next;
            }
        }
        ListNode firstHead = null;
        ListNode lastTail = null;

        for (int i = 0; i < heads.length; i++) {
            if (heads[i] == null) {
                continue;
            }
            if (firstHead == null) {
                firstHead = heads[i];
            }
            if (lastTail == null) {
                lastTail = tails[i];
            } else {
                lastTail.next = heads[i];
                lastTail = tails[i];
            }

        }
        return firstHead;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}