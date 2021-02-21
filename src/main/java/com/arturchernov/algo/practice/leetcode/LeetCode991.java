package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 991. Broken Calculator
 * <p>
 * On a broken calculator that has a number showing on its display, we can perform two operations:
 * <p>
 * Double: Multiply the number on the display by 2, or;
 * Decrement: Subtract 1 from the number on the display.
 * Initially, the calculator is displaying the number X.
 * <p>
 * Return the minimum number of operations needed to display the number Y.
 */
public class LeetCode991 {

    public static void main(String[] args) {
        System.out.println(brokenCalc(2, 3));
        System.out.println(brokenCalc(5, 8));
        System.out.println(brokenCalc(3, 10));
        System.out.println(brokenCalc(1024, 1));
    }

    public static int brokenCalc(int X, int Y) {
        int ans = 0;
        while (true) {
            if (Y <= X) {
                ans += X - Y;
                break;
            } else if (Y % 2 == 1) {
                Y++;
            } else {
                Y /= 2;
            }
            ans++;
        }
        return ans;
    }
}