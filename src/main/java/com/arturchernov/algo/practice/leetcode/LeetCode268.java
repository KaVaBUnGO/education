package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 268. Missing Number
 * <p>
 * Given an array nums containing n distinct numbers in the range [0, n],
 * return the only number in the range that is missing from the array.
 * <p>
 * Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?
 */
public class LeetCode268 {

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));
        System.out.println(missingNumber(new int[]{0, 1}));
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        System.out.println(missingNumber(new int[]{0}));
    }

    public static int missingNumber(int[] nums) {
        int sum = nums.length % 2 == 0 ? (nums.length + 1) * (nums.length / 2) : (nums.length) * ((nums.length - 1) / 2) + nums.length;
        for (Integer num : nums) {
            sum -= num;
        }
        return sum;
    }
}