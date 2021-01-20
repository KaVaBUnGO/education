package com.arturchernov.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 20. Valid Parentheses
 */
public class LeetCode20 {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("{[]}"));
        System.out.println(isValid("{"));
        System.out.println(isValid("}"));
    }

    public static boolean isValid(String s) {
        Stack<Character> temp = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                temp.add(ch);
            } else if (!temp.isEmpty() && map.get(temp.peek()) == ch) {
                temp.pop();
            } else {
                return false;
            }
        }
        return temp.isEmpty();
    }
}