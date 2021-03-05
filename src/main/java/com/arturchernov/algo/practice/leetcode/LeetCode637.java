package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 637. Average of Levels in Binary Tree
 * <p>
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
 * Example 1:
 * Input:
 * 3
 * / \
 * 9  20
 * / \
 * 15  7
 * Output: [3, 14.5, 11]
 * Explanation:
 * The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
 */
public class LeetCode637 {

    public static void main(String[] args) {
        System.out.println(averageOfLevels(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Pair pair = new Pair();
        pair.add(root);
        while (pair.row.size() > 0) {
            ans.add(pair.getAns());
            pair = calc(pair);
        }
        return ans;
    }

    private static Pair calc(Pair pair) {
        Pair newPair = new Pair();
        for (TreeNode node : pair.row) {
            if (node.left != null) {
                newPair.add(node.left);
            }
            if (node.right != null) {
                newPair.add(node.right);
            }
        }
        return newPair;
    }

    private static class Pair {
        double ans = 0;
        List<TreeNode> row = new ArrayList<>();

        public Pair() {
        }

        public void add(TreeNode node) {
            ans += node.val;
            row.add(node);
        }

        public double getAns() {
            return ans / row.size();
        }
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