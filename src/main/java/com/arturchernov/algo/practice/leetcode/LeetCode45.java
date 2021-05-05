package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 45. Jump Game II
 * <p>
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * You can assume that you can always reach the last index.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 * <p>
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */
public class LeetCode45 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode45()).start();
    }

    @Override
    public void run() {
        System.out.println(jump(new int[]{4, 1, 1, 3, 1, 1, 1}));
        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{3, 2, 1}));
        System.out.println(jump(new int[]{1, 2}));
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 3, 0, 1, 4}));
    }

    public int jump(int[] nums) {
        int ans = 0;
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, nums[i] + i);
            if (cur == i) {
                ans++;
                cur = max;
                if (cur >= nums.length - 1) {
                    break;
                }
            }
        }
        return ans;
    }
}
