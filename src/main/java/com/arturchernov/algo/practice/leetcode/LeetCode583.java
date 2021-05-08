package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 583. Delete Operation for Two Strings
 * <p>
 * Given two strings word1 and word2, return the minimum number
 * of steps required to make word1 and word2 the same.
 * <p>
 * In one step, you can delete exactly one character in either string.
 * <p>
 * Example 1:
 * <p>
 * Input: word1 = "sea", word2 = "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Example 2:
 * <p>
 * Input: word1 = "leetcode", word2 = "etco"
 * Output: 4
 * <p>
 * Constraints:
 * <p>
 * 1 <= word1.length, word2.length <= 500
 * word1 and word2 consist of only lowercase English letters.
 */
public class LeetCode583 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode583()).start();
    }

    @Override
    public void run() {
        System.out.println(minDistance("a", "a"));
        System.out.println(minDistance("ba", "ab"));
        System.out.println(minDistance("", "eat"));
        System.out.println(minDistance("sea", "eat"));
        System.out.println(minDistance("leetcode", "etco"));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return (n - dp[n][m]) + (m - dp[n][m]);
    }
}
