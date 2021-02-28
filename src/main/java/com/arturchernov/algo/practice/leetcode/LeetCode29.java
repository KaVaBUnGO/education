package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 29. Divide Two Integers
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero, which means losing its fractional part. For example,
 * truncate(8.345) = 8 and truncate(-2.7335) = -2.
 * <p>
 * Note:
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range:
 * [−231,  231 − 1]. For this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class LeetCode29 {

    public static void main(String[] args) {
        System.out.println(divide(10, 3));
        System.out.println(divide(7, -3));
        System.out.println(divide(0, 1));
        System.out.println(divide(1, 1));
        System.out.println(divide(200, 2));
        System.out.println(divide(200, 3));
        System.out.println(divide(200, 66));
        System.out.println(divide(200, 25));
        System.out.println(divide(200, 26));
        System.out.println(divide(-2147483648, -1));
        System.out.println(divide(-2147483648, -2147483648));
        System.out.println(divide(-2147483648, 2147483647));
        System.out.println(divide(2147483646, 2147483647));
        System.out.println(divide(-2147483648, 1));
        System.out.println(divide(2147483647, 2));
        System.out.println(divide(-1010369383, -2147483648));

    }

    public static int divide(int dividend, int divisor) {
        if (dividend == divisor) {
            return 1;
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        boolean sign = true;
        int ans = 0;
        if (divisor < 0) {
            divisor = -divisor;
            sign = !sign;
        }
        if (dividend < 0) {
            if (dividend == Integer.MIN_VALUE) {
                dividend += divisor;
                ++ans;
            }
            dividend = -dividend;
            sign = !sign;
        }

        if (divisor > dividend) {
            return sign ? ans : -ans;
        }

        if (divisor == 1) {
            return sign ? (dividend == Integer.MAX_VALUE ? dividend : dividend + ans) : -dividend - ans;
        }

        while (dividend >= divisor) {
            long k = divisor;
            int i = 0;
            while (dividend >= (k << 1)) {
                k <<= 1;
                ++i;
            }
            dividend -= k;
            ans = i == 0 ? ++ans : ans + (2 << (i - 1));
        }
        return sign ? ans : -ans;
    }
}