package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * Leetcode 1673. Find the Most Competitive Subsequence
 * <p>
 * Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.
 * <p>
 * An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.
 * <p>
 * We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position
 * where a and b differ, subsequence a has a number less than the corresponding number in b. For example, [1,3,4]
 * is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.
 */
public class LeetCode1673 {

    public static void main(String[] args) {
        int[] test1 = new int[]{3, 5, 2, 6};
        System.out.println(Arrays.toString(mostCompetitive(test1, 2)));
        int[] test2 = new int[]{2, 4, 3, 3, 5, 4, 9, 6};
        System.out.println(Arrays.toString(mostCompetitive(test2, 4)));
        int[] test3 = new int[]{1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(mostCompetitive(test3, 5)));
    }

    public static int[] mostCompetitive(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }
        int[] mins = new int[nums.length - k];
        for (int i = nums.length - k - 1; i >= 0; i--) {
            mins[i] = i == nums.length - k - 1 ? nums[i] : Math.min(mins[i + 1], nums[i]);
        }
        int firstLeft = 0;
        int secondLeft = nums.length - k;
        int[] ans = new int[k];
        int ansIndex = 0;
        boolean isGet = false;
        while (ansIndex < k) {
            secondLeft = findMin(nums, secondLeft, nums.length - k + ansIndex, isGet);
            if (firstLeft < mins.length && mins[firstLeft] <= nums[secondLeft]) {
                ans[ansIndex++] = mins[firstLeft];
                while (nums[firstLeft] != mins[firstLeft]) {
                    ++firstLeft;
                }
                ++firstLeft;
            } else {
                ans[ansIndex++] = nums[secondLeft++];
                firstLeft = mins.length;
                isGet = true;
            }
        }
        return ans;
    }

    private static int findMin(int[] nums, int start, int end, boolean isGet) {
        if (isGet) {
            int pos = start;
            for (int i = start; i <= end; i++) {
                if (nums[i] < nums[pos]) {
                    pos = i;
                }
            }
            return pos;
        } else {
            return nums[end] < nums[start] ? end : start;
        }
    }
}