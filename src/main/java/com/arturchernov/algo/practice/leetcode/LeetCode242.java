package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 242. Valid Anagram
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 */
public class LeetCode242 {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("aaa", "aa"));
        System.out.println(isAnagram("aaa", "aaa"));
        System.out.println(isAnagram("", ""));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] hash = new int['z' + 1];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)]++;
            hash[t.charAt(i)]--;
        }
        for (int j : hash) {
            if (j != 0) {
                return false;
            }
        }
        return true;
    }
}