package com.arturchernov.algo.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1461. Check If a String Contains All Binary Codes of Size K
 * <p>
 * Given a binary string s and an integer k.
 * <p>
 * Return True if every binary code of length k is a substring of s. Otherwise, return False.
 */
public class LeetCode1461 {

    public static void main(String[] args) {
        System.out.println(hasAllCodes("00110110", 2));
        System.out.println(hasAllCodes("00110", 2));
        System.out.println(hasAllCodes("0110", 1));
        System.out.println(hasAllCodes("0110", 2));
        System.out.println(hasAllCodes("0000000001011100", 4));
        System.out.println(hasAllCodes("00", 4));
    }

    public static boolean hasAllCodes(String s, int k) {
        int count = 1 << k;
        Set<String> hash = new HashSet<>();
        for (int i = 0; i <= s.length() - k; i++) {
            hash.add(s.substring(i, i + k));
            if (hash.size() == count) {
                return true;
            }
        }
        return false;
    }
}