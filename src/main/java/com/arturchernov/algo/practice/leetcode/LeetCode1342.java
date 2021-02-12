package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1342. Number of Steps to Reduce a Number to Zero
 * <p>
 * Given a non-negative integer num, return the number of steps to reduce it to zero.
 * If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
public class LeetCode1342 {

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(123));
    }

    public static int numberOfSteps(int num) {
        int ans = 0;
        while (num > 0) {
            ans++;
            num = (num % 2 == 0) ? num / 2 : num - 1;
        }
        return ans;
    }
}