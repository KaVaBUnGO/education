package com.arturchernov.algo.practice.leetcode;

import com.arturchernov.algo.practice.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1302. Deepest Leaves Sum
 * <p>
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 */
public class LeetCode1302 {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8};
        System.out.println(deepestLeavesSum(LeetCodeUtils.buildTree(a)));
        Integer[] a2 = new Integer[]{6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5};
        System.out.println(deepestLeavesSum(LeetCodeUtils.buildTree(a2)));
        Integer[] a3 = new Integer[]{1};
        System.out.println(deepestLeavesSum(LeetCodeUtils.buildTree(a3)));
    }

    public static int deepestLeavesSum(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        boolean last;
        while (true) {
            last = true;
            List<TreeNode> newList = new ArrayList<>();
            for (TreeNode node : list) {
                if (node.left != null) {
                    last = false;
                    newList.add(node.left);
                }
                if (node.right != null) {
                    last = false;
                    newList.add(node.right);
                }
            }
            if (!last) {
                list = newList;
            } else {
                break;
            }
        }
        int sum = 0;
        for (TreeNode node : list) {
            sum += node.val;
        }
        return sum;
    }
}