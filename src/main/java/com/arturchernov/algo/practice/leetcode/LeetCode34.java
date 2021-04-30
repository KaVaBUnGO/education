package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 34. Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 * <p>
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * Example 3:
 * <p>
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * <p>
 * Constraints:
 * <p>
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class LeetCode34 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode34()).run();
    }

    @Override
    public void run() {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{}, 0)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = findStart(nums, target);
        ans[1] = findEnd(nums, target);
        return ans;
    }

    private int findStart(int[] a, int t) {
        int res = -1;
        int l = 0, r = a.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (a[m] >= t) {
                r = m - 1;
            } else {
                l = m + 1;
            }
            if (a[m] == t) {
                res = m;
            }
        }
        return res;
    }

    private int findEnd(int[] a, int t) {
        int res = -1;
        int l = 0, r = a.length - 1;
        int m;
        while (l <= r) {
            m = (l + r) / 2;
            if (a[m] <= t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
            if (a[m] == t) {
                res = m;
            }
        }
        return res;
    }
}
