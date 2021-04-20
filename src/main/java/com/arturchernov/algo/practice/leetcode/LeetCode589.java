package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 589: N-ary Tree Preorder Traversal
 * <p>
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 * Example 1:
 * <p>
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * Example 2:
 * <p>
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The height of the n-ary tree is less than or equal to 1000.
 */
public class LeetCode589 {

    public static void main(String[] args) {
        Node root1 = build(new Integer[]{1, null, 3, 2, 4, null, 5, 6});
        System.out.println(preorder(root1));
        Node root2 = build(new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null, null, 11, null, 12, null, 13, null, null, 14});
        System.out.println(preorder(root2));
    }

    private static Node build(Integer[] a) {
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(a[0]);
        q.add(root);
        for (int i = 2; i < a.length; i++) {
            if (a[i] != null) {
                Node node = new Node(a[i]);
                q.add(node);
                if (q.peek().children == null) {
                    q.peek().children = new ArrayList<>();
                }
                q.peek().children.add(node);
            } else {
                q.poll();
            }
        }
        return root;
    }

    public static List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root != null) {
            ans.add(root.val);
            fillChild(root, ans);
        }
        return ans;
    }

    private static void fillChild(Node node, List<Integer> ans) {
        if (node.children == null)
            return;
        for (int i = 0; i < node.children.size(); i++) {
            ans.add(node.children.get(i).val);
            fillChild(node.children.get(i), ans);
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}