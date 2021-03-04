package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * 160. Intersection of Two Linked Lists
 * <p>
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5].
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 */
public class LeetCode160 {

    public static void main(String[] args) {
        ListNode[] list = buildList(2, 3, new int[]{4, 1, 8, 4, 5}, new int[]{5, 6, 1, 8, 4, 5});
        //ListNode[] list = buildList(0, 0, new int[]{}, new int[]{});
        System.out.println(getIntersectionNode(list[0], list[1]));
    }

    /* Input generator */

    private static ListNode[] buildList(int p1, int p2, int[] vals1, int[] vals2) {
        ListNode[] first = buildList(Arrays.copyOf(vals1, p1), null, null);
        ListNode[] second = buildList(Arrays.copyOf(vals2, p2), null, null);
        ListNode[] res = buildList(Arrays.copyOfRange(vals1, p1, vals1.length), null, null);

        if (first[1] != null) {
            first[1].next = res[0];
        } else {
            first = res;
        }
        if (second[1] != null) {
            second[1].next = res[0];
        } else {
            second = res;
        }
        return new ListNode[]{first[0], second[0]};
    }

    private static ListNode[] buildList(int[] vals, ListNode head, ListNode prev) {
        if (vals.length == 0) {
            return new ListNode[]{null, null};
        }
        head = head == null ? new ListNode(vals[0]) : head;
        prev = prev == null ? head : prev;
        for (int i = 1; i < vals.length; i++) {
            ListNode t = new ListNode(vals[i]);
            prev.next = t;
            prev = t;
        }
        return new ListNode[]{head, prev};
    }

    /* Solution */

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int deepA = getDeep(headA);
        int deepB = getDeep(headB);

        ListNode iterA = headA;
        ListNode iterB = headB;

        for (int i = 0; i < deepA - deepB; i++) {
            iterA = iterA.next;
        }

        for (int i = 0; i < deepB - deepA; i++) {
            iterB = iterB.next;
        }

        ListNode ans = null;
        while (iterA != null) {
            if (iterA == iterB) {
                if (ans == null) {
                    ans = iterA;
                }
            } else {
                ans = null;
            }
            iterA = iterA.next;
            iterB = iterB.next;
        }
        return ans;
    }

    private static int getDeep(ListNode node) {
        int len = 0;
        ListNode it = node;
        while (it != null) {
            it = it.next;
            ++len;
        }
        return len;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}