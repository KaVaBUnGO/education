package com.arturchernov.algo.practice.leetcode;

import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 946. Validate Stack Sequences
 * <p>
 * Given two sequences pushed and popped with distinct values, return true if and only
 * if this could have been the result of a sequence of push and pop operations on an initially empty stack.
 */
public class LeetCode946 {

    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 2, 1, 5}));
        System.out.println(validateStackSequences(new int[]{1}, new int[]{4}));
        System.out.println(validateStackSequences(new int[]{}, new int[]{}));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int it = 0;
        for (int i : pushed) {
            if (i == popped[it]) {
                ++it;
                while (!st.isEmpty() && st.peek() == popped[it]) {
                    st.pop();
                    it++;
                }
            } else {
                st.push(i);
            }
        }
        return st.isEmpty();
    }
}