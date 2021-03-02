package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 645. Set Mismatch
 * <p>
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately,
 * due to some error, one of the numbers in s got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 * <p>
 * You are given an integer array nums representing the data status of this set after the error.
 * <p>
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 */
public class LeetCode645 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 2, 2, 4})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{1, 1})));
        System.out.println(Arrays.toString(findErrorNums(new int[]{2, 2})));
    }

    public static int[] findErrorNums(int[] nums) {
        int d = 0, s = 0;
        int[] hash = new int[nums.length];
        for (int num : nums) {
            hash[num - 1]++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] == 2) {
                d = i;
            } else if (hash[i] == 0) {
                s = i;
            }
        }
        return new int[]{d + 1, s + 1};
    }
}