package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 19: Remove Nth Node From End of List
 * <p>
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class LeetCode19 {

    public static void main(String[] args) {
        print(removeNthFromEnd(build(new int[]{1, 2, 3, 4, 5}), 2));
        print(removeNthFromEnd(build(new int[]{1}), 2));
        print(removeNthFromEnd(build(new int[]{1, 2}), 1));
        print(removeNthFromEnd(build(new int[]{1, 2}), 2));
    }

    public static ListNode build(int[] a) {
        ListNode root = new ListNode(a[0]);
        ListNode last = root;
        for (int i = 1; i < a.length; i++) {
            last.next = new ListNode(a[i]);
            last = last.next;
        }
        return root;
    }

    public static void print(ListNode root) {
        while (root != null) {
            System.out.print(root.val + " ");
            root = root.next;
        }
        System.out.println();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        List<ListNode> list = new ArrayList<>();
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }
        if (list.size() == 1) {
            return null;
        }
        if (n == list.size()) {
            return head.next;
        }
        if (n == 1) {
            list.get(list.size() - 2).next = null;
            return head;
        }
        list.get(list.size() - n - 1).next = list.get(list.size() - n + 1);
        return head;
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