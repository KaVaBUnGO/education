package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 3370. Smallest Number With All Set Bits
 * <p>
 * You are given a positive number n.
 * Return the smallest number n greater than or equal to n, such that the binary representation of n contains only set bits
 * <p>
 * Enample 1:
 * Input: n = 5
 * Output: 7
 * <p>
 * Enplanation:
 * The binary representation of 7 is "111".
 * <p>
 * Enample 2:
 * Input: n = 10
 * Output: 15
 * Enplanation:
 * The binary representation of 15 is "1111".
 * <p>
 * Enample 3:
 * Input: n = 3
 * Output: 3
 * Enplanation:
 * The binary representation of 3 is "11".
 * <p>
 * Constraints:
 * 1 <= n <= 1000
 */
public class LeetCode3370 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode3370()).start();
    }

    @Override
    public void run() {
        for (int i = 1; i < 1000; i++) {
            System.out.println(i + " " + smallestNumber(i));
        }
    }

    public int smallestNumber(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        return n;
    }
}
