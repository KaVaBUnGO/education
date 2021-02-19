package com.arturchernov.algo.practice.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1249. Minimum Remove to Make Valid Parentheses
 * <p>
 * Given a string s of '(' , ')' and lowercase English characters.
 * <p>
 * Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions )
 * so that the resulting parentheses string is valid and return any valid string.
 * <p>
 * Formally, a parentheses string is valid if and only if:
 * <p>
 * It is the empty string, contains only lowercase characters, or
 * It can be written as AB (A concatenated with B), where A and B are valid strings, or
 * It can be written as (A), where A is a valid string.
 */
public class LeetCode1249 {

    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
        System.out.println(minRemoveToMakeValid(""));
    }

    public static String minRemoveToMakeValid(String s) {
        Set<Integer> wrong = new HashSet<>();
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else if (s.charAt(i) == ')') {
                if (!st.isEmpty()) {
                    st.pop();
                } else {
                    wrong.add(i);
                }
            }
        }
        wrong.addAll(st);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!wrong.contains(i)) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}