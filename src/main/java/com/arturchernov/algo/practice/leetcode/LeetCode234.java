package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 234. Palindrome Linked List
 * <p>
 * Given the head of a singly linked list, return true if it is a palindrome.
 */
public class LeetCode234 {

    public static void main(String[] args) {
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
        System.out.println(isPalindrome(new ListNode(1, new ListNode(2, new ListNode(1)))));
        System.out.println(isPalindrome(new ListNode(1, new ListNode(1, new ListNode(1)))));
        System.out.println(isPalindrome(new ListNode(1, new ListNode(1, new ListNode(2)))));
    }

    public static boolean isPalindrome(ListNode head) {
        List<Integer> numbers = new ArrayList<>();
        while (head != null) {
            numbers.add(head.val);
            head = head.next;
        }
        int l = 0;
        int r = numbers.size() - 1;
        while (l < r) {
            if ((numbers.get(l++) != numbers.get(r--))){
                return false;
            }
        }
        return true;
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