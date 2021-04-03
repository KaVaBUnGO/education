package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 474. Ones and Zeroes
 * <p>
 * You are given an array of binary strings strs and two integers m and n.
 * <p>
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 * <p>
 * A set x is a subset of a set y if all elements of x are also elements of y.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
 * Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
 * Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
 * {"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
 * Example 2:
 * <p>
 * Input: strs = ["10","0","1"], m = 1, n = 1
 * Output: 2
 * Explanation: The largest subset is {"0", "1"}, so the answer is 2.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] consists only of digits '0' and '1'.
 * 1 <= m, n <= 100
 */
public class LeetCode474 {

    public static void main(String[] args) {
        System.out.println(findMaxForm(new String[]{"11111", "100", "1101", "1101", "11000"}, 5, 7));
        System.out.println(findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
        System.out.println(findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        System.out.println(findMaxForm(new String[]{"110", "00", "001"}, 1, 1));
        System.out.println(findMaxForm(new String[]{"11", "11", "11"}, 1, 1));
        System.out.println(findMaxForm(new String[]{"11", "11", "11"}, 0, 7));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        List<Pair> pairs = new ArrayList<>();
        for (String str : strs) {
            int k = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '0') {
                    k++;
                }
            }
            if (k <= m && str.length() - k <= n) {
                pairs.add(new Pair(k, str.length() - k));
            }
        }

        int[][] dp = new int[m + 1][n + 1];
        for (Pair p : pairs) {
            for (int i = m; i >= p.x; i--) {
                for (int j = n; j >= p.y; j--) {
                    dp[i][j] = Math.max(1 + dp[i - p.x][j - p.y], dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}