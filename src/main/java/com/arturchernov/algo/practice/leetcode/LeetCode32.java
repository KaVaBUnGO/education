package com.arturchernov.algo.practice.leetcode;

import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 32. Longest Valid Parentheses
 * <p>
 * Given a string containing just the characters '(' and ')',
 * find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Example 2:
 * <p>
 * Input: s = ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()".
 * Example 3:
 * <p>
 * Input: s = ""
 * Output: 0
 */
public class LeetCode32 {

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()(((()") == 2);
        System.out.println(longestValidParentheses("(()()") == 4);
        System.out.println(longestValidParentheses("()(()") == 2);
        System.out.println(longestValidParentheses("((((") == 0);
        System.out.println(longestValidParentheses("((()))") == 6);
        System.out.println(longestValidParentheses("(()") == 2);
        System.out.println(longestValidParentheses(")()())") == 4);
        System.out.println(longestValidParentheses("") == 0);
    }

    public static int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.add(i);
            } else {
                if (!st.empty()) {
                    dp[i] = true;
                    dp[st.pop()] = true;
                }
            }
        }
        int max = 0;
        int localMax = 0;
        for (boolean j : dp) {
            if (j) {
                localMax++;
            } else {
                max = Math.max(localMax, max);
                localMax = 0;
            }
        }
        return Math.max(max, localMax);
    }
}