package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 647. Palindromic Substrings
 * <p>
 * Given a string, your task is to count how many palindromic substrings in this string.
 * <p>
 * The substrings with different start indexes or end indexes are counted
 * as different substrings even they consist of same characters.
 */
public class LeetCode647 {

    public static void main(String[] args) {
        System.out.println(countSubstrings(""));
        System.out.println(countSubstrings("a"));
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    ans++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < s.length()) {
                if (s.charAt(l) == s.charAt(r)) {
                    ans++;
                    l--;
                    r++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}