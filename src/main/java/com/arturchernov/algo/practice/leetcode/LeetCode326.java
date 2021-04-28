package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 326. Power of Three
 * <p>
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 * <p>
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 27
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 0
 * Output: false
 * Example 3:
 * <p>
 * Input: n = 9
 * Output: true
 * Example 4:
 * <p>
 * Input: n = 45
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * Follow up: Could you solve it without loops/recursion?
 */
public class LeetCode326 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode326()).run();
    }

    @Override
    public void run() {
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(1));
        System.out.println(isPowerOfThree(3));
        System.out.println(isPowerOfThree(9));
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(45));
    }

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }
}
