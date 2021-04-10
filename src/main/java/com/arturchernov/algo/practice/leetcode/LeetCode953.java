package com.arturchernov.algo.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 953. Verifying an Alien Dictionary
 * <p>
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order.
 * The order of the alphabet is some permutation of lowercase letters.
 * <p>
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only
 * if the given words are sorted lexicographicaly in this alien language.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 * <p>
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 * <p>
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.)
 * According to lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the
 * blank character which is less than any other character (More info).
 */
public class LeetCode953 {

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    public static boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            dict.put(order.charAt(i), i);
        }
        if (words.length == 1) {
            return true;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (!isLess(words[i], words[i + 1], dict)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isLess(String s1, String s2, Map<Character, Integer> dict) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return dict.get(s1.charAt(i)) - dict.get(s2.charAt(i)) <= 0;
            }
        }
        return len == s1.length();
    }
}