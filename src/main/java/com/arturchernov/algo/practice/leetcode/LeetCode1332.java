package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1332. Remove Palindromic Subsequences
 * <p>
 * Given a string s consisting only of letters 'a' and 'b'.
 * In a single step you can remove one palindromic subsequence from s.
 * <p>
 * Return the minimum number of steps to make the given string empty.
 * <p>
 * A string is a subsequence of a given string,
 * if it is generated by deleting some characters of a given string without changing its order.
 * <p>
 * A string is called palindrome if is one that reads the same backward as well as forward.
 */
public class LeetCode1332 {

    public static void main(String[] args) {
        System.out.println(removePalindromeSub("ababa"));
        System.out.println(removePalindromeSub("abb"));
        System.out.println(removePalindromeSub("baabb"));
        System.out.println(removePalindromeSub(""));
        System.out.println(removePalindromeSub("abababbbbababbabbbbbba"));
    }

    public static int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return 1;
        }
        return 2;
    }
}