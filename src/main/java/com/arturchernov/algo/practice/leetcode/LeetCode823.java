package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 823. Binary Trees With Factors
 * <p>
 * Given an array of unique integers, arr, where each integer arr[i] is strictly greater than 1.
 * <p>
 * We make a binary tree using these integers, and each number may be used for any number of times.
 * Each non-leaf node's value should be equal to the product of the values of its children.
 * <p>
 * Return the number of binary trees we can make. The answer may be too large so return the answer modulo 10^9 + 7.
 */
public class LeetCode823 {

    public static void main(String[] args) {
        System.out.println(numFactoredBinaryTrees(new int[]{2, 4, 5, 10}));
        System.out.println(numFactoredBinaryTrees(new int[]{2, 4, 16}));
        System.out.println(numFactoredBinaryTrees(new int[]{2, 4}));
        System.out.println(numFactoredBinaryTrees(new int[]{2}));
    }

    public static int numFactoredBinaryTrees(int[] a) {
        long ans = 0;
        Arrays.sort(a);
        long[] dp = new long[a.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < a.length; i++) {
            for (int k1 = 0; k1 <= i; k1++) {
                if ((long) a[k1] * 2 > a[i]) {
                    break;
                }
                for (int k2 = 0; k2 <= k1; k2++) {
                    if ((long) a[k1] * (long) a[k2] > a[i]) {
                        break;
                    }
                    if (a[k1] * a[k2] == a[i]) {
                        if (k1 == k2) {
                            dp[i] = dp[i] + dp[k1] * dp[k2];
                        } else {
                            dp[i] = dp[i] + 2 * (dp[k1] * dp[k2]);
                        }
                    }
                }
            }
            ans += dp[i];
        }
        return (int) (ans % (Math.pow(10, 9) + 7));
    }
}