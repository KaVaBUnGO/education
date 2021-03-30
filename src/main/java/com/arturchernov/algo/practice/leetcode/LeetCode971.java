package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 971. Flip Binary Tree To Match Preorder Traversal
 * <p>
 * You are given the root of a binary tree with n nodes, where each node is uniquely assigned a value from 1 to n.
 * You are also given a sequence of n values voyage, which is the desired pre-order traversal of the binary tree.
 * <p>
 * Any node in the binary tree can be flipped by swapping its left and right subtrees.
 * <p>
 * Flip the smallest number of nodes so that the pre-order traversal of the tree matches voyage.
 * <p>
 * Return a list of the values of all flipped nodes. You may return the answer in any order.
 * If it is impossible to flip the nodes in the tree to make the pre-order traversal match voyage, return the list [-1].
 * <p>
 * The number of nodes in the tree is n.
 * n == voyage.length
 * 1 <= n <= 100
 * 1 <= Node.val, voyage[i] <= n
 * All the values in the tree are unique.
 * All the values in voyage are unique.
 */
public class LeetCode971 {

    private static int it = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(flipMatchVoyage(root, new int[]{1, 3, 2}));
    }

    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>();
        int it = 0;
        return find(root, voyage, ans) ? ans : List.of(-1);
    }

    private static Boolean find(TreeNode node, int[] voyage, List<Integer> ans) {
        if (node == null) {
            return true;
        }
        if (node.val != voyage[it++]) {
            return false;
        }

        if (node.left != null && node.left.val != voyage[it]) {
            ans.add(node.val);
            return find(node.right, voyage, ans) && find(node.left, voyage, ans);
        }
        return find(node.left, voyage, ans) && find(node.right, voyage, ans);
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