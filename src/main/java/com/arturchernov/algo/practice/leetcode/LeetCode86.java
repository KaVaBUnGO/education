package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 86: Partition List
 * <p>
 * Given the head of a linked list and a value x, partition
 * it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,4,3,2,5,2], x = 3
 * Output: [1,2,2,4,3,5]
 * Example 2:
 * <p>
 * Input: head = [2,1], x = 2
 * Output: [1,2]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [0, 200].
 * -100 <= Node.val <= 100
 * -200 <= x <= 200
 */
public class LeetCode86 {

    public static void main(String[] args) {
        int[] input = {1, 4, 3, 2, 5, 2};
        ListNode head = new ListNode(input[0]);
        ListNode realHead = head;
        for (int i = 1; i < input.length; i++) {
            head.next = new ListNode(input[i]);
            head = head.next;
        }
        ListNode ans = partition(realHead, 3);
        while (ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode newHead = null;
        ListNode secondHead = null;
        ListNode first = null;
        ListNode second = null;
        while (head != null) {
            if (head.val < x) {
                if (first == null) {
                    first = head;
                    newHead = first;
                } else {
                    first.next = head;
                    first = first.next;
                }
            } else {
                if (second == null) {
                    second = head;
                    secondHead = second;
                } else {
                    second.next = head;
                    second = second.next;
                }
            }
            head = head.next;
        }
        if (second != null) {
            second.next = null;
        }
        if (first == null) {
            return secondHead;
        }
        first.next = secondHead;
        return newHead;
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