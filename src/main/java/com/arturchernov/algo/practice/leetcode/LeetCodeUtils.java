package com.arturchernov.algo.practice.leetcode;

import com.arturchernov.algo.practice.leetcode.commons.ListNode;
import com.arturchernov.algo.practice.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Artur Chernov
 */
public final class LeetCodeUtils {
    /* Build matrix from String input, like as [[x, x, x], [x, x, x], [x, x, x]] */
    public static int[][] buildMatrix(String s) {
        s = s.replace(" ", "");
        s = s.substring(2, s.length() - 2);
        String[] rows = s.split("],\\[");
        int[][] res = new int[rows.length][];
        for (int i = 0; i < rows.length; i++) {
            String[] numbers = rows[i].split(",");
            int[] row = new int[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                row[j] = Integer.parseInt(numbers[j]);
            }
            res[i] = row;
        }
        return res;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static ListNode buildLinkedList(int[] input) {
        if (input.length == 0) return null;
        ListNode root = new ListNode(input[0]);
        ListNode tail = root;
        for (int i = 1; i < input.length; i++) {
            tail.next = new ListNode(input[i]);
            tail = tail.next;
        }
        return root;
    }

    public static void print(TreeNode root) {
        if (root == null) return;

        List<TreeNode> ans = new ArrayList<>();
        ans.add(root);
        while (!ans.isEmpty()) {
            ans = print(ans);
        }
        System.out.println();
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

}
