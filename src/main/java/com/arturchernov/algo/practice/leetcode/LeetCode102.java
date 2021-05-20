package com.arturchernov.algo.practice.leetcode;

import com.arturchernov.algo.practice.leetcode.commons.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 102. Binary Tree Level Order Traversal
 * <p>
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 * <p>
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class LeetCode102 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode102()).start();
    }

    @Override
    public void run() {
        System.out.println(levelOrder(LeetCodeUtils.buildTree(new Integer[]{3, 9, 20, null, null, 15, 7})));
        System.out.println(levelOrder(LeetCodeUtils.buildTree(new Integer[]{1})));
        System.out.println(levelOrder(LeetCodeUtils.buildTree(new Integer[]{})));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<TreeNode> local = new ArrayList<>();
        List<Integer> localAns = new ArrayList<>();
        localAns.add(root.val);
        ans.add(localAns);
        local.add(root);

        while (local.size() > 0) {
            List<TreeNode> newLocal = new ArrayList<>();
            localAns = new ArrayList<>();
            for (TreeNode node : local) {
                if (node.left != null) {
                    newLocal.add(node.left);
                    localAns.add(node.left.val);
                }
                if (node.right != null) {
                    newLocal.add(node.right);
                    localAns.add(node.right.val);
                }
            }
            if (localAns.size() > 0) {
                ans.add(localAns);
            }
            local = newLocal;
        }
        return ans;
    }
}
