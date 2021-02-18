package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 413. Arithmetic Slices
 * <p>
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between
 * any two consecutive elements is the same.
 * <p>
 * For example, these are arithmetic sequences:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * The following sequence is not arithmetic.
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.
 * <p>
 * A slice (P, Q) of the array A is called arithmetic if the sequence:
 * A[P], A[P + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.
 * <p>
 * The function should return the number of arithmetic slices in the array A.
 */
public class LeetCode413 {

    public static void main(String[] args) {
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
        System.out.println(numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
    }

    public static int numberOfArithmeticSlices(int[] A) {
        int ans = 0;
        int cur = 2;
        int end = A.length;
        int len = 1;
        while (cur < end) {
            if (A[cur] - A[cur - 1] == A[cur - 1] - A[cur - 2]) {
                cur++;
                ans += len;
                len++;
            } else {
                cur++;
                len = 1;
            }
        }
        return ans;
    }
}