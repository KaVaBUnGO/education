package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1704. Determine if String Halves Are Alike
 * <p>
 * You are given a string s of even length. Split this string into two halves of equal lengths,
 * and let a be the first half and b be the second half.
 * <p>
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U').
 * Notice that s contains uppercase and lowercase letters.
 * <p>
 * Return true if a and b are alike. Otherwise, return false.
 */
public class LeetCode1704 {

    public static void main(String[] args) {
        System.out.println(halvesAreAlike(""));
        System.out.println(halvesAreAlike("book"));
        System.out.println(halvesAreAlike("textbook"));
        System.out.println(halvesAreAlike("MerryChristmas"));
        System.out.println(halvesAreAlike("AbCdEfGh"));
    }

    public static boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int res = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (vowels.contains(s.charAt(i))) {
                res++;
            }
            if (vowels.contains(s.charAt(s.length() - 1 - i))) {
                res--;
            }
        }
        return res == 0;
    }
}