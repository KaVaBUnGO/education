package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1641. Count Sorted Vowel Strings
 */
public class LeetCode1641 {

    public static void main(String[] args) {
        System.out.println(countVowelStrings(1));
        System.out.println(countVowelStrings(2));
        System.out.println(countVowelStrings(3));
        System.out.println(countVowelStrings(4));
        System.out.println(countVowelStrings(50));
    }

    public static int countVowelStrings(int n) {
        int[][] dp = new int[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[0][i] = i + 1;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[n - 1][4];
    }
}
