package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 462. Minimum Moves to Equal Array Elements II
 * <p>
 * Given an integer array nums of size n, return the minimum number of moves required to make all array elements equal.
 * <p>
 * In one move, you can increment or decrement an element of the array by 1.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: 2
 * Explanation:
 * Only two moves are needed (remember each move increments or decrements one element):
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * Example 2:
 * <p>
 * Input: nums = [1,10,2,9]
 * Output: 16
 * <p>
 * Constraints:
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class LeetCode462 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode462()).start();
    }

    @Override
    public void run() {
        System.out.println(minMoves2(new int[]{1, 2, 3, -5}));
        System.out.println(minMoves2(new int[]{1, 2, 3}));
        System.out.println(minMoves2(new int[]{1, 10, 2, 9}));
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(median - nums[i]);
        }
        return ans;
    }
}
