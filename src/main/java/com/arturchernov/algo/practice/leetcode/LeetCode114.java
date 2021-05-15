package com.arturchernov.algo.practice.leetcode;

import com.arturchernov.algo.practice.leetcode.commons.TreeNode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 114. Flatten Binary Tree to Linked List
 * <p>
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next
 * node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [1,2,5,3,4,null,6]
 * Output: [1,null,2,null,3,null,4,null,5,null,6]
 * Example 2:
 * <p>
 * Input: root = []
 * Output: []
 * Example 3:
 * <p>
 * Input: root = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 2000].
 * -100 <= Node.val <= 100
 */
public class LeetCode114 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode114()).start();
    }

    @Override
    public void run() {
        flatten(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6))));
    }

    public void flatten(TreeNode root) {
        search(root, null);
    }

    private TreeNode search(TreeNode node, TreeNode res) {
        if (node == null) return res;

        res = search(node.right, res);
        res = search(node.left, res);
        node.left = null;
        node.right = res;
        return node;
    }
}
