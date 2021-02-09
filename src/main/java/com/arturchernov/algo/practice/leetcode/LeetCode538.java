package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 538. Convert BST to Greater Tree
 * <p>
 * Given the root of a Binary Search Tree (BST), convert it to a Greater Tree such that every key of
 * the original BST is changed to the original key plus sum of all keys greater than the original key in BST.
 */
public class LeetCode538 {

    static int id = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(1, new TreeNode(0), new TreeNode(2, null, new TreeNode(3))),
                new TreeNode(6, new TreeNode(5), new TreeNode(7, null, new TreeNode(8))));

        convertBST(root);

        List<TreeNode> ans = new ArrayList<>();
        ans.add(root);
        while (!ans.isEmpty()) {
            ans = print(ans);
        }
    }

    private static List<TreeNode> print(List<TreeNode> ans) {
        List<TreeNode> res = new ArrayList<>();
        for (TreeNode node : ans) {
            if (node.left != null) {
                res.add(node.left);
            }
            if (node.right != null) {
                res.add(node.right);
            }
            System.out.print(node.val + " ");
        }
        return res;
    }

    public static TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        int[] sum = new int[2 * 10000 + 1];
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode curr = deque.pop();
            if (curr.left != null) {
                deque.add(curr.left);
            }
            if (curr.right != null) {
                deque.add(curr.right);
            }
            sum[curr.val + 10000] = curr.val;
        }
        for (int i = sum.length - 1; i > 0; i--) {
            sum[i - 1] = sum[i] + sum[i - 1];
        }
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode curr = deque.pop();
            if (curr.left != null) {
                deque.add(curr.left);
            }
            if (curr.right != null) {
                deque.add(curr.right);
            }
            curr.val = sum[curr.val + 10000];
        }
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}