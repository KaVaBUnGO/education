package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 821. Shortest Distance to a Character
 * <p>
 * Given a string s and a character c that occurs in s, return an array of integers answer where
 * answer.length == s.length and answer[i] is the shortest distance from s[i] to the character c in s.
 */
public class LeetCode821 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(shortestToChar("loveleetcode", 'e')));
        System.out.println(Arrays.toString(shortestToChar("aaab", 'b')));
    }

    public static int[] shortestToChar(String s, char c) {
        int[] ans = new int[s.length()];
        boolean find = false;
        int last = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                ans[i] = 0;
                for (int j = i - 1; j >= last; j--) {
                    if (ans[j] > i - j) {
                        ans[j] = i - j;
                    } else {
                        break;
                    }
                }
                last = i;
                find = true;
            } else {
                ans[i] = find ? i - last : 10001;
            }
        }
        return ans;
    }
}