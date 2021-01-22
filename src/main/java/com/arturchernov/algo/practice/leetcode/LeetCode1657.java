package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1657. Determine if Two Strings Are Close
 * <p>
 * Two strings are considered close if you can attain one from the other using the following operations:
 * <p>
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 * <p>
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */
public class LeetCode1657 {

    public static void main(String[] args) {
        System.out.println(closeStrings("abc", "bca"));
        System.out.println(closeStrings("a", "aa"));
        System.out.println(closeStrings("cabbba", "abbccc"));
        System.out.println(closeStrings("cabbba", "aabbss"));
        System.out.println(closeStrings("xxxxxxxxxxxxxxxxxxx", "zzzzzzzzzzzzzzzzzzz"));
    }

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        int[] hash1 = new int[27];
        int[] hash2 = new int[27];
        for (int i = 0; i < word1.length(); i++) {
            hash1[word1.charAt(i) - 'a']++;
            hash2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < hash1.length; i++) {
            if ((hash1[i] == 0 && hash2[i] != 0) || (hash2[i] == 0 && hash1[i] != 0)) {
                return false;
            }
        }
        Arrays.sort(hash1);
        Arrays.sort(hash2);
        for (int i = 0; i < hash1.length; i++) {
            if (hash1[i] != hash2[i]) {
                return false;
            }
        }
        return true;
    }
}