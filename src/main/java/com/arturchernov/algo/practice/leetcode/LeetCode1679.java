package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1679. Max Number of K-Sum Pairs
 */
public class LeetCode1679 {

    public static void main(String[] args) {
        int[] test1 = new int[]{1, 2, 3, 4};
        System.out.println(maxOperations(test1, 5));
        int[] test2 = new int[]{1, 3, 3, 3, 4};
        System.out.println(maxOperations(test2, 6));
        int[] test3 = new int[]{1, 1};
        System.out.println(maxOperations(test3, 2));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int ans = 0;
        while (start < end) {
            if (nums[start] + nums[end] == k) {
                ++ans;
                ++start;
                --end;
            } else if (nums[start] + nums[end] > k) {
                --end;
            } else {
                ++start;
            }
        }
        return ans;
    }
}
