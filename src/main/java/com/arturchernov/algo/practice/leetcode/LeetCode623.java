package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 623. Add One Row to Tree
 * <p>
 * Given the root of a binary tree, then value v and depth d,
 * you need to add a row of nodes with value v at the given depth d. The root node is at depth 1.
 * <p>
 * The adding rule is: given a positive integer depth d, for each NOT null tree nodes N in depth d-1,
 * create two tree nodes with value v as N's left subtree root and right subtree root. And N's original
 * left subtree should be the left subtree of the new left subtree root, its original right subtree
 * should be the right subtree of the new right subtree root. If depth d is 1 that means there is no depth d-1 at all,
 * then create a tree node with value v as the new root of the whole original tree,
 * and the original tree is the new root's left subtree.
 */
public class LeetCode623 {

    public static void main(String[] args) {
        TreeNode test1 = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null));
        TreeNode test2 = new TreeNode(2);
        TreeNode x = addOneRow(test2, 1, 2);
        System.out.println(x);
    }

    public static TreeNode addOneRow(TreeNode root, int v, int d) {
        List<TreeNode> cur = new ArrayList<>();
        cur.add(root);
        int lvl = 1;
        if (d == 1) {
            return new TreeNode(v, root, null);
        }
        while (lvl != d) {
            cur = getNextLevel(cur, v, ++lvl == d);
        }
        return root;
    }

    public static List<TreeNode> getNextLevel(List<TreeNode> nodes, int v, boolean isInsert) {
        List<TreeNode> newNodes = new ArrayList<>();
        for (TreeNode node : nodes) {
            if (!isInsert) {
                if (node.left != null) {
                    newNodes.add(node.left);
                }
                if (node.right != null) {
                    newNodes.add(node.right);
                }
            } else {
                if (node.left != null) {
                    node.left = new TreeNode(v, node.left, null);
                } else {
                    node.left = new TreeNode(v);
                }
                if (node.right != null) {
                    node.right = new TreeNode(v, null, node.right);
                } else {
                    node.right = new TreeNode(v);
                }
            }
        }
        return newNodes;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    "}";
        }
    }
}