package com.arturchernov.algo.practice.leetcode;

import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1209. Remove All Adjacent Duplicates in String II
 * <p>
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s
 * and removing them causing the left and the right side of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made.
 * <p>
 * It is guaranteed that the answer is unique.
 */
public class LeetCode1209 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abcd", 2));
        System.out.println(removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (st.empty() || st.peek().ch != s.charAt(i)) {
                st.push(new Pair(current));
            } else if (st.peek().count < k - 1) {
                st.peek().inc();
            } else {
                st.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Pair pair : st) {
            for (int j = 0; j < pair.count; j++) {
                sb.append(pair.ch);
            }
        }
        return sb.toString();
    }

    private static class Pair {
        public char ch;
        public int count;

        public Pair(char ch) {
            this.ch = ch;
            this.count = 1;
        }

        public void inc() {
            this.count++;
        }
    }

}