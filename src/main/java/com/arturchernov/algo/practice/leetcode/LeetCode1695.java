package com.arturchernov.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1695. Maximum Erasure Value
 * <p>
 * You are given an array of positive integers nums and want to erase a subarray containing unique elements.
 * The score you get by erasing the subarray is equal to the sum of its elements.
 * <p>
 * Return the maximum score you can get by erasing exactly one subarray.
 * <p>
 * An array b is called to be a subarray of a if it forms a contiguous subsequence of a,
 * that is, if it is equal to a[l],a[l+1],...,a[r] for some (l,r).
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,2,4,5,6]
 * Output: 17
 * Explanation: The optimal subarray here is [2,4,5,6].
 * Example 2:
 * <p>
 * Input: nums = [5,2,1,2,5,2,1,2,5]
 * Output: 8
 * Explanation: The optimal subarray here is [5,2,1] or [1,2,5].
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 104
 */
public class LeetCode1695 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode1695()).start();
    }

    @Override
    public void run() {
        System.out.println(maximumUniqueSubarray(new int[]{1, 2, 3}));
        System.out.println(maximumUniqueSubarray(new int[]{5, 5, 5}));
        System.out.println(maximumUniqueSubarray(new int[]{5, 5}));
        System.out.println(maximumUniqueSubarray(new int[]{5}));
        System.out.println(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
        System.out.println(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }

    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int localSum = 0;
        int lastLeft = 0;
        for (int i = 0; i < nums.length; i++) {
            int k = nums[i];
            if (map.containsKey(k)) {
                Integer localRight = map.get(k);
                for (int j = lastLeft; j <= localRight; j++) {
                    map.remove(nums[j]);
                    localSum -= nums[j];
                }
                lastLeft = localRight + 1;
            }
            map.put(k, i);
            localSum += k;
            ans = Math.max(ans, localSum);
        }
        return ans;
    }
}
