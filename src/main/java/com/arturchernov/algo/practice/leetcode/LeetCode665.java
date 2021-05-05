package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 665. Non-decreasing Array
 * <p>
 * Given an array nums with n integers, your task is to check if it could become
 * non-decreasing by modifying at most one element.
 * <p>
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i
 * (0-based) such that (0 <= i <= n - 2).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 * <p>
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * -105 <= nums[i] <= 105
 */
public class LeetCode665 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode665()).start();
    }

    @Override
    public void run() {
        System.out.println(checkPossibility(new int[]{1, 4, 1, 2}));
        System.out.println(checkPossibility(new int[]{5, 7, 1, 2, 8}));
        System.out.println(checkPossibility(new int[]{5, 7, 1, 8}));
        System.out.println(checkPossibility(new int[]{-1, 4, 2, 3}));
        System.out.println(checkPossibility(new int[]{1, 2, 3, 0}));
        System.out.println(checkPossibility(new int[]{4, 3, 2, 3}));
        System.out.println(checkPossibility(new int[]{3, 4, 2, 3}));
        System.out.println(checkPossibility(new int[]{5}));
        System.out.println(checkPossibility(new int[]{4, 2, 3}));
        System.out.println(checkPossibility(new int[]{4, 2, 1}));
    }

    public boolean checkPossibility(int[] a) {
        boolean flag = false;
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                if (!(flag = !flag)) {
                    return false;
                }
                if (i - 2 < 0 || a[i - 2] <= a[i]) {
                    a[i - 1] = a[i];
                } else {
                    a[i] = a[i - 1];
                }
            }
        }
        return true;
    }
}
