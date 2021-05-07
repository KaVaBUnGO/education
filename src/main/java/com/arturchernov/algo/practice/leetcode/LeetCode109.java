package com.arturchernov.algo.practice.leetcode;

import com.arturchernov.algo.practice.leetcode.commons.ListNode;
import com.arturchernov.algo.practice.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 109. Convert Sorted List to Binary Search Tree
 * <p>
 * Given the head of a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the
 * depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * Example 2:
 * <p>
 * Input: head = []
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [0]
 * Output: [0]
 * Example 4:
 * <p>
 * Input: head = [1,3]
 * Output: [3,1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in head is in the range [0, 2 * 104].
 * -10^5 <= Node.val <= 10^5
 */
public class LeetCode109 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode109()).start();
    }

    @Override
    public void run() {
        LeetCodeUtils.print(sortedListToBST(LeetCodeUtils.buildLinkedList(new int[]{})));
        LeetCodeUtils.print(sortedListToBST(LeetCodeUtils.buildLinkedList(new int[]{0})));
        LeetCodeUtils.print(sortedListToBST(LeetCodeUtils.buildLinkedList(new int[]{1, 3})));
        LeetCodeUtils.print(sortedListToBST(LeetCodeUtils.buildLinkedList(new int[]{-10, -3, 0, 5, 9})));
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;

        List<Integer> a = new ArrayList<>();
        while (head != null) {
            a.add(head.val);
            head = head.next;
        }
        return build(a, 0, a.size() - 1);
    }

    private TreeNode build(List<Integer> a, int l, int r) {
        if (r - l == 0) return new TreeNode(a.get(l));
        if (r - l == 1) return new TreeNode(a.get(r), new TreeNode(a.get(l)), null);
        int mid = (r + l) / 2;
        return new TreeNode(a.get(mid), build(a, l, mid - 1), build(a, mid + 1, r));
    }
}
