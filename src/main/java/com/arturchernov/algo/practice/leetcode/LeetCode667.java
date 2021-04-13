package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 667. Beautiful Arrangement II
 * <p>
 * Given two integers n and k, you need to construct a list which contains n different
 * positive integers ranging from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|]
 * has exactly k distinct integers.
 * <p>
 * If there are multiple answers, print any of them.
 */
public class LeetCode667 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(constructArray(3, 2)));
        System.out.println(Arrays.toString(constructArray(3, 1)));
        System.out.println(Arrays.toString(constructArray(5, 4)));
        System.out.println(Arrays.toString(constructArray(5, 3)));
        System.out.println(Arrays.toString(constructArray(5, 2)));
        System.out.println(Arrays.toString(constructArray(5, 1)));
    }

    public static int[] constructArray(int n, int k) {
        int[] ans = new int[n];
        int left = 1, right = n;
        int it = 0;
        while (it < n) {
            if (it < k) {
                if (it % 2 == 0)
                    ans[it++] = left++;
                else
                    ans[it++] = right--;
            } else {
                if (k % 2 == 1) {
                    for (int i = left; i <= right; i++) {
                        ans[it++] = i;
                    }
                } else {
                    for (int i = right; i >= left; i--) {
                        ans[it++] = i;
                    }
                }
            }
        }
        return ans;
    }
}