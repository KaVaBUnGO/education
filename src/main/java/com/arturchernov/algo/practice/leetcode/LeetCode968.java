package com.arturchernov.algo.practice.leetcode;

import com.arturchernov.algo.practice.leetcode.commons.TreeNode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 968. Binary Tree Cameras
 * <p>
 * Given a binary tree, we install cameras on the nodes of the tree.
 * <p>
 * Each camera at a node can monitor its parent, itself, and its immediate children.
 * <p>
 * Calculate the minimum number of cameras needed to monitor all nodes of the tree.
 * <p>
 * Example 1:
 * <p>
 * Input: [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.
 * Example 2:
 * <p>
 * <p>
 * Input: [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the tree.
 * The above image shows one of the valid configurations of camera placement.
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be in the range [1, 1000].
 * Every node has value 0.
 */
public class LeetCode968 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode968()).start();
    }

    @Override
    public void run() {
        System.out.println(minCameraCover(LeetCodeUtils.buildTree(new Integer[]{0, 0, null, 0, 0})));
        ans = 0;
        System.out.println(minCameraCover(LeetCodeUtils.buildTree(new Integer[]{0, 0, null, 0, null, 0, null, null, 0})));
    }

    private int ans = 0;

    public int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + ans;
    }

    /*
     * 0 - for leaf
     * 1 - parent of leaf with camera
     * 2 - covered without camera in node
     * */
    private int dfs(TreeNode root) {
        if (root == null) {
            return 2;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 0 || right == 0) {
            ans++;
            return 1;
        }

        if (left == 1 || right == 1) {
            return 2;
        } else {
            return 0;
        }
    }
}
