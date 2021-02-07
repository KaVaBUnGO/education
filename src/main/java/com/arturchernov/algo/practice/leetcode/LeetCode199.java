package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 199. Binary Tree Right Side View
 * <p>
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom
 */
public class LeetCode199 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
//        root.right.right = new TreeNode(4);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return Collections.emptyList();
        }
        List<Integer> ans = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);
        while (nodes.size() != 0) {
            nodes = getValue(nodes, ans);
        }
        return ans;
    }

    private static List<TreeNode> getValue(List<TreeNode> nodes, List<Integer> ans) {
        ans.add(nodes.get(0).val);
        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (node.right != null) {
                newNodes.add(node.right);
            }
            if (node.left != null) {
                newNodes.add(node.left);
            }
        }
        return newNodes;
    }

    private static class TreeNode {
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