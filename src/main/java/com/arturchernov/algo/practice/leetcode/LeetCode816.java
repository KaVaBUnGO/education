package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 816. Ambiguous Coordinates
 * <p>
 * We had some 2-dimensional coordinates, like "(1, 3)" or "(2, 0.5)".  Then, we removed all commas, decimal points,
 * and spaces, and ended up with the string s.  Return a list of strings representing all possibilities for
 * what our original coordinates could have been.
 * <p>
 * Our original representation never had extraneous zeroes, so we never started with numbers like
 * "00", "0.0", "0.00", "1.0", "001", "00.01", or any other number that can be represented with less digits.
 * Also, a decimal point within a number never occurs without at least one digit occuring before it,
 * so we never started with numbers like ".1".
 * <p>
 * The final answer list can be returned in any order.  Also note that all coordinates in the
 * final answer have exactly one space between them (occurring after the comma.)
 * <p>
 * Example 1:
 * Input: s = "(123)"
 * Output: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * Example 2:
 * Input: s = "(00011)"
 * Output:  ["(0.001, 1)", "(0, 0.011)"]
 * Explanation:
 * 0.0, 00, 0001 or 00.01 are not allowed.
 * Example 3:
 * Input: s = "(0123)"
 * Output: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * Example 4:
 * Input: s = "(100)"
 * Output: [(10, 0)]
 * Explanation:
 * 1.0 is not allowed.
 * <p>
 * Note:
 * <p>
 * 4 <= s.length <= 12.
 * s[0] = "(", s[s.length - 1] = ")", and the other elements in s are digits.
 */
public class LeetCode816 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode816()).start();
    }

    @Override
    public void run() {
        System.out.println(ambiguousCoordinates("(00)"));
        System.out.println(ambiguousCoordinates("(0000)"));
        System.out.println(ambiguousCoordinates("(123456781234)"));
        System.out.println(ambiguousCoordinates("(123)"));
        System.out.println(ambiguousCoordinates("(00011)"));
        System.out.println(ambiguousCoordinates("(0123)"));
        System.out.println(ambiguousCoordinates("(100)"));
    }

    public List<String> ambiguousCoordinates(String s) {
        int len = s.length();
        List<String> ans = new ArrayList<>();
        for (int i = 2; i < len - 1; i++) {
            List<String> first = getCombinations(s.substring(1, i));
            List<String> second = getCombinations(s.substring(i, len - 1));
            for (String left : first) {
                for (String right : second) {
                    ans.add("(" + left + ", " + right + ")");
                }
            }
        }
        return ans;
    }

    private List<String> getCombinations(String s1) {
        List<String> res = new ArrayList<>();
        int len = s1.length();
        if (len == 1) {
            res.add(s1);
            return res;
        }
        if (s1.charAt(0) != '0') {
            res.add(s1);
        }

        for (int i = 1; i < len; i++) {
            String left = s1.substring(0, i);
            String right = s1.substring(i, len);
            boolean allowedRight = right.charAt(right.length() - 1) != '0';
            if (!allowedRight)
                return res;
            boolean allowedLeft = left.length() == 1 || left.charAt(0) != '0';
            if (allowedLeft) {
                res.add(left + '.' + right);
            }
        }
        return res;
    }
}
