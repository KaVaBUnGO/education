package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 376. Wiggle Subsequence
 * <p>
 * Given an integer array nums, return the length of the longest wiggle sequence.
 * <p>
 * A wiggle sequence is a sequence where the differences between successive numbers strictly alternate
 * between positive and negative. The first difference (if one exists) may be either positive or negative.
 * A sequence with fewer than two elements is trivially a wiggle sequence.
 * <p>
 * For example, [1, 7, 4, 9, 2, 5] is a wiggle sequence because the differences (6, -3, 5, -7, 3) are
 * alternately positive and negative. In contrast, [1, 4, 7, 2, 5] and [1, 7, 4, 5, 5] are not wiggle sequences,
 * the first because its first two differences are positive and the second because its last difference is zero.
 * A subsequence is obtained by deleting some elements (eventually, also zero) from the original sequence,
 * leaving the remaining elements in their original order.
 */
public class LeetCode376 {

    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1, 1, 7, 4, 9, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{0, 0}));
        System.out.println(wiggleMaxLength(new int[]{3, 3, 3, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(wiggleMaxLength(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        System.out.println(wiggleMaxLength(new int[]{1, 3, 1, 3, 3, 3, 1, 1, 3}));
    }

    public static int wiggleMaxLength(int[] a) {
        if (a.length == 1 || (a.length == 2 && a[0] == a[1])) {
            return 1;
        }
        if (a.length == 2) {
            return 2;
        }
        int ans = 2;
        int it1 = 0, it2 = 1;
        while (it2 < a.length && a[it1] == a[it2]) {
            ++it2;
        }
        if (it2 >= a.length - 1) {
            return 1;
        }
        int it3 = it2 + 1;
        while (it3 < a.length) {
            if ((a[it1] > a[it2] && a[it2] < a[it3]) ||
                    a[it1] < a[it2] && a[it2] > a[it3]) {
                ans++;
                it1 = it2;
                it2 = it3;
                it3 = it2 + 1;

            } else if ((a[it1] > a[it2] && a[it2] > a[it3]) ||
                    (a[it1] < a[it2] && a[it2] < a[it3])) {
                it2 = it3;
                it3 = it2 + 1;
            } else {
                it3++;
            }
        }

        return ans;
    }
}