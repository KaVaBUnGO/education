package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 869. Reordered Power of 2
 * <p>
 * Starting with a positive integer N, we reorder the digits in any order
 * (including the original order) such that the leading digit is not zero.
 * <p>
 * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
 */
public class LeetCode869 {

    public static void main(String[] args) {
        System.out.println(reorderedPowerOf2(10000000));
        System.out.println(reorderedPowerOf2(1));
        System.out.println(reorderedPowerOf2(10));
        System.out.println(reorderedPowerOf2(16));
        System.out.println(reorderedPowerOf2(24));
        System.out.println(reorderedPowerOf2(46));
    }

    public static boolean reorderedPowerOf2(int N) {
        HashSet<Long> pows = new HashSet<>();
        int it = 0;
        while (true) {
            long k = 1L << it;
            if (k > 1000000000) {
                break;
            }
            pows.add(sort(k));
            ++it;
        }
        return pows.contains(sort(N));
    }

    private static long sort(long k) {
        List<Short> a = new ArrayList<>();
        while (k > 0) {
            a.add((short) (k % 10));
            k /= 10;
        }
        a.sort(Collections.reverseOrder());
        long ans = 0;
        for (Short s : a) {
            ans *= 10;
            ans += s;
        }
        return ans;
    }
}