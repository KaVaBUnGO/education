package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1048. Longest String Chain
 * <p>
 * Given a list of words, each word consists of English lowercase letters.
 * <p>
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly one letter anywhere
 * in word1 to make it equal to word2. For example, "abc" is a predecessor of "abac".
 * <p>
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >= 1, where word_1 is a
 * predecessor of word_2, word_2 is a predecessor of word_3, and so on.
 * <p>
 * Return the longest possible length of a word chain with words chosen from the given list of words.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["a","b","ba","bca","bda","bdca"]
 * Output: 4
 * Explanation: One of the longest word chain is "a","ba","bda","bdca".
 * Example 2:
 * <p>
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
 * Output: 5
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 16
 * words[i] only consists of English lowercase letters.
 */
public class LeetCode1048 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode1048()).start();
    }

    @Override
    public void run() {
        System.out.println(longestStrChain(new String[]{"a","ab","ac","bd","abc","abd","abdd"}));
        System.out.println(longestStrChain(new String[]{"abcd", "dbqca"}));
        System.out.println(longestStrChain(new String[]{"a", "b", "ab", "bac"}));
        System.out.println(longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
        System.out.println(longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}));
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        int[] dp = new int[words.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected(words[j], words[i])) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;
    }

    private boolean isConnected(String word1, String word2) {
        if (word2.length() - word1.length() != 1) return false;

        int it1 = 0, it2 = 0;
        boolean flag = false;

        while (it1 < word1.length() && it2 < word2.length()) {
            if (word1.charAt(it1) != word2.charAt(it2)) {
                if (flag) {
                    return false;
                }
                flag = true;
            } else {
                ++it1;
            }
            ++it2;
        }
        return true;
    }

}
