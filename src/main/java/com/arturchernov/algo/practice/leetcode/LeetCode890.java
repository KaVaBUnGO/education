package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 890. Find and Replace Pattern
 * <p>
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern.
 * You may return the answer in any order.
 * <p>
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x
 * in the pattern with p(x), we get the desired word.
 * <p>
 * Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
 * and no two letters map to the same letter.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * Output: ["mee","aqq"]
 * Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 * "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.
 * Example 2:
 * <p>
 * Input: words = ["a","b","c"], pattern = "a"
 * Output: ["a","b","c"]
 * <p>
 * Constraints:
 * <p>
 * 1 <= pattern.length <= 20
 * 1 <= words.length <= 50
 * words[i].length == pattern.length
 * pattern and words[i] are lowercase English letters.
 */
public class LeetCode890 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode890()).start();
    }

    @Override
    public void run() {
        System.out.println(findAndReplacePattern(new String[]{"a", "b", "c"}, "a"));
        System.out.println(findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();
        int length = pattern.length();
        for (String w : words) {
            if (w.length() != length) {
                continue;
            }
            if (checkPattern(w, pattern)) {
                ans.add(w);
            }
        }
        return ans;
    }

    private boolean checkPattern(String w, String pattern) {
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < w.length(); i++) {
            char first = w.charAt(i);
            char second = pattern.charAt(i);
            if (map.containsKey(first)) {
                if (map.get(first) != second) {
                    return false;
                }
            } else {
                if (map.containsValue(second)) {
                    return false;
                }
                map.put(first, second);
            }
        }
        return true;
    }
}

