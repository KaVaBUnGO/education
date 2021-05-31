package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 164. Maximum Gap
 * <p>
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
 * If the array contains less than two elements, return 0.
 * <p>
 * You must write an algorithm that runs in linear time and uses linear extra space.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3,6,9,1]
 * Output: 3
 * Explanation: The sorted form of the array is [1,3,6,9], either (3,6) or (6,9) has the maximum difference 3.
 * Example 2:
 * <p>
 * Input: nums = [10]
 * Output: 0
 * Explanation: The array contains less than 2 elements, therefore return 0.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 10^9
 */
public class LeetCode164 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode164()).start();
    }

    @Override
    public void run() {
        System.out.println(maximumGap(new int[]{3, 6, 9, 1}));
        System.out.println(maximumGap(new int[]{10}));
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int largest = nums[0];
        int[] aux = new int[nums.length];
        int divisor = 1;
        for (int i : nums) largest = Math.max(largest, i);
        while (largest / divisor > 0) {
            int[] count = new int[10];
            for (int i = 0; i < nums.length; i++) {
                count[(nums[i] / divisor) % 10]++;
            }
            for (int i = 1; i < count.length; i++) {
                count[i] += count[i - 1];
            }
            for (int i = nums.length - 1; i >= 0; i--) {
                aux[--count[(nums[i] / divisor) % 10]] = nums[i];
            }
            System.arraycopy(aux, 0, nums, 0, nums.length);
            divisor = divisor * 10;
        }
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res = Math.max(res, nums[i] - nums[i - 1]);
        }
        return res;
    }
}
