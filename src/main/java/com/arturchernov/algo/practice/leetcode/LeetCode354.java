package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 354. Russian Doll Envelopes
 * <p>
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents
 * the width and the height of an envelope.
 * <p>
 * One envelope can fit into another if and only if both the width and height of one envelope are
 * greater than the other envelope's width and height.
 * <p>
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * <p>
 * Note: You cannot rotate an envelope.
 */
public class LeetCode354 {

    public static void main(String[] args) {
        System.out.println(maxEnvelopes(new int[][]{{4, 5}, {4, 6}, {6, 7}, {2, 3}, {1, 1}}));
        System.out.println(maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
        System.out.println(maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return 1;
                } else if (o1[0] < o2[0]) {
                    return -1;
                } else {
                    return Integer.compare(o1[1], o2[1]);
                }
            }
        });

        int dp[] = new int[envelopes.length];

        for (int i = 0; i < dp.length; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][0] != envelopes[i][0] && envelopes[j][1] < envelopes[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = dp[0];
        for (int i = 0; i < dp.length; i++) {
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}