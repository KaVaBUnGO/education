package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 581. Shortest Unsorted Continuous Subarray
 * <p>
 * Given an integer array nums, you need to find one continuous subarray that if you only sort this
 * subarray in ascending order, then the whole array will be sorted in ascending order.
 * <p>
 * Return the shortest such subarray and output its length.
 */
public class LeetCode581 {

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(findUnsortedSubarray(new int[]{1, 2, 3, 4}));
        System.out.println(findUnsortedSubarray(new int[]{1}));
        System.out.println(findUnsortedSubarray(new int[]{}));
        System.out.println(findUnsortedSubarray(new int[]{5, 4, 3, 2, 1}));
        System.out.println(findUnsortedSubarray(new int[]{2, 1}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 2, 2}));
        System.out.println(findUnsortedSubarray(new int[]{1, 3, 2, 4, 5}));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int start = -1, end = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                if (start == -1) {
                    start = i + 1;
                }
                end = i + 1;
            }
        }
        if (start == -1) {
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = end; i >= 0; i--) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max) {
                end = i + 1;
                break;
            }
        }
        return end - start;
    }
}