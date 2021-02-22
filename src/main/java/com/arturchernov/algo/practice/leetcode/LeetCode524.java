package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 524. Longest Word in Dictionary through Deleting
 * <p>
 * Given a string and a string dictionary, find the longest string in the dictionary that can be formed
 * by deleting some characters of the given string. If there are more than one possible results, return the
 * longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 * <p>
 * Example 1:
 */
public class LeetCode524 {

    public static void main(String[] args) {
        System.out.println(findLongestWord("abpcplea", Arrays.asList("ale", "appfle", "monkey", "abc", "pdlea")));
        System.out.println(findLongestWord("abpcplea", Arrays.asList("a", "b", "c")));
    }

    public static String findLongestWord(String s, List<String> d) {
        String ans = "";
        for (String w : d) {
            if (checkWord(s, w)) {
                if (w.length() > ans.length() || (w.length() == ans.length() && s.compareTo(w) > 0)) {
                    ans = w;
                }
            }
        }
        return ans;
    }

    private static boolean checkWord(String s, String v) {
        if (s.length() < v.length()) {
            return false;
        }
        int it1 = 0, it2 = 0;
        while (it1 != s.length() && it2 != v.length()) {
            if (s.charAt(it1) == v.charAt(it2)) {
                it1++;
                it2++;
            } else {
                it1++;
            }
        }
        return it2 == v.length();
    }
}