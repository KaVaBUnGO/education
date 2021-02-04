package com.arturchernov.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 594. Longest Harmonious Subsequence
 * <p>
 * We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.
 * <p>
 * Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.
 * <p>
 * A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing
 * the order of the remaining elements.
 */
public class LeetCode594 {

    public static void main(String[] args) {
        System.out.println(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7}));
        System.out.println(findLHS(new int[]{1, 2, 3, 4}));
        System.out.println(findLHS(new int[]{1, 1, 1, 1}));
    }

    public static int findLHS(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int num : nums) {
            hm.compute(num, (v1, v2) -> v2 != null ? ++v2 : 1);
        }
        int ans = 0;
        for (Integer key : hm.keySet()) {
            if (hm.containsKey(key + 1)) {
                ans = Math.max(ans, hm.get(key) + hm.get(key + 1));
            }
        }
        return ans;
    }
}