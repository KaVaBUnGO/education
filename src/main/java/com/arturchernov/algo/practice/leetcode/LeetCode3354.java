package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 3354. Make Array Elements Equal to Zero
 * <p>
 * You are given an integer array nums.
 * Start by selecting a starting position curr such that nums[curr] == 0, and choose a movement direction of either left or right.
 * After that, you repeat the following process:
 * If curr is out of the range [0, n - 1], this process ends.
 * If nums[curr] == 0, move in the current direction by incrementing curr if you are moving right, or decrementing curr if you are moving left.
 * Else if nums[curr] > 0:
 * Decrement nums[curr] by 1.
 * Reverse your movement direction (left becomes right and vice versa).
 * Take a step in your new direction.
 * A selection of the initial position curr and movement direction is considered valid if every element in nums becomes 0 by the end of the process.
 * Return the number of possible valid selections.
 * <p>
 * Input: nums = [1,0,2,0,3]
 * Output: 2
 * Explanation:
 * The only possible valid selections are the following:
 * Choose curr = 3, and a movement direction to the left.
 * [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,1,0,3] -> [1,0,1,0,3] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,0,0,2] -> [1,0,0,0,2] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,0].
 * Choose curr = 3, and a movement direction to the right.
 * [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,2,0,2] -> [1,0,2,0,2] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,1,0,1] -> [1,0,1,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [0,0,0,0,0].
 * <p>
 * Example 2:
 * Input: nums = [2,3,4,0,4,1,0]
 * Output: 0
 * Explanation:
 * There are no possible valid selections.
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * There is at least one element i where nums[i] == 0.
 */
public class LeetCode3354 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode3354()).start();
    }

    @Override
    public void run() {
        System.out.println(countValidSelections(new int[]{1, 0, 2, 0, 3}));
        System.out.println(countValidSelections(new int[]{16,13,10,0,0,0,10,6,7,8,7}));
    }

    public int countValidSelections(int[] nums) {
        int ans = 0;
        int sumR = Arrays.stream(nums).sum();
        int sumL = 0;
        for (int num : nums) {
            if (num == 0 && sumL == sumR) {
                ans += 2;
            }
            if (num == 0 && Math.abs(sumL - sumR) == 1) {
                ans += 1;
            }
            sumL += num;
            sumR -= num;
        }
        return ans;
    }
}
