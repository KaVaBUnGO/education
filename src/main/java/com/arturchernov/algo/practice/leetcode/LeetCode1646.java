package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 *
 * LeetCode 1646. Get Maximum in Generated Array
 */
public class LeetCode1646 {

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println(i + ": " + getMaximumGenerated(i));
        }
    }


    public static int getMaximumGenerated(int n) {
        if (n < 2) {
            return n;
        }
        short[] seq = new short[n + 1];
        short[] max = new short[n + 1];
        seq[0] = 0;
        max[0] = 0;
        seq[1] = 1;
        max[1] = 1;
        for (short i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                seq[i] = seq[i / 2];
            } else {
                seq[i] = (short) (seq[i / 2] + seq[i / 2 + 1]);
            }
            max[i] = (short) Math.max(seq[i], max[i - 1]);
        }
        return max[n];
    }

}
