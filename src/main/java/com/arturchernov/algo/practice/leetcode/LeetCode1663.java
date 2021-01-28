package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1663. Smallest String With A Given Numeric Value
 * <p>
 * The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, so the numeric
 * value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.
 * <p>
 * The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' numeric
 * values.
 * For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.
 * <p>
 * You are given two integers n and k. Return the lexicographically smallest string with length equal to n and numeric
 * value equal to k.
 * <p>
 * Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is,
 * either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in
 * alphabetic order.
 */
public class LeetCode1663 {

    public static void main(String[] args) {
        System.out.println(getSmallestString(5, 73));
    }

    public static String getSmallestString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int p = (k - n) % 25;
        int z = (k - n) / 25;
        sb.append("a".repeat(Math.max(0, n - z - (p > 0 ? 1 : 0))));
        if (p > 0) {
            sb.append((char) ('a' + p));
        }
        sb.append("z".repeat(Math.max(0, z)));
        return sb.toString();
    }
}