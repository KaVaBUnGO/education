package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 5. Longest Palindromic Substring
 */
public class LeetCode5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("aa"));
        System.out.println(longestPalindrome("aaa"));
        System.out.println(longestPalindrome("aba"));
        System.out.println(longestPalindrome("abba"));
        System.out.println(longestPalindrome("cabba"));
        System.out.println(longestPalindrome("cfabba"));
        System.out.println(longestPalindrome("cfabbasdfasgdfag"));
        System.out.println(longestPalindrome("cfabcdedcbasdfasgdfag"));
        System.out.println(longestPalindrome("aaaaaa"));
    }

    public static String longestPalindrome(String s) {
        int ans = 1;
        int middle = 0;
        int type = 1;
        for (int i = 0; i < s.length(); i++) {
            int oddAns = calcLength(s, i, i) - 1;
            if (oddAns > ans) {
                ans = oddAns;
                middle = i;
                type = 1;
            }
            int evenAns = calcLength(s, i, i + 1);
            if (evenAns > ans) {
                ans = evenAns;
                middle = i;
                type = 0;
            }
        }
        if (type == 0) {
            int half = (ans / 2);
            return s.substring(middle - (half - 1), (middle + 1) + (half - 1) + 1);
        } else {
            int half = (ans - 1) / 2;
            return s.substring(middle - half, middle + half + 1);
        }
    }

    private static int calcLength(String s, int l, int r) {
        int ans = 0;
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                ans += 2;
                --l;
                ++r;
            } else {
                break;
            }
        }
        return ans;
    }
}