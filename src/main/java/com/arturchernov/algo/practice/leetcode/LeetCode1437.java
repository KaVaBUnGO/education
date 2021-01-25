package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1437. Check If All 1's Are at Least Length K Places Away
 * <p>
 * Given an array nums of 0s and 1s and an integer k, return True if all 1's are at least k places away from each other,
 * otherwise return False.
 */
public class LeetCode1437 {

    public static void main(String[] args) {
        System.out.println(kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        System.out.println(kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(kLengthApart(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(kLengthApart(new int[]{0, 1, 0, 1}, 1));
        System.out.println(kLengthApart(new int[]{0, 1, 0, 0}, 1));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIndex != -1 && i - lastIndex - 1 < k) {
                    return false;
                }
                lastIndex = i;
            }
        }
        return true;
    }
}