package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 215. Kth Largest Element in an Array
 */
public class LeetCode215 {

    public static void main(String[] args) {
        int[] testCase1 = new int[]{3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(testCase1, 2));

        int[] testCase2 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(testCase2, 1));
    }


    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

}
