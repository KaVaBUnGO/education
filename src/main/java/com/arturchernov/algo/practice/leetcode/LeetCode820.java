package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 820. Short Encoding of Words
 * <p>
 * A valid encoding of an array of words is any reference string s and array of indices indices such that:
 * <p>
 * words.length == indices.length
 * The reference string s ends with the '#' character.
 * For each index indices[i], the substring of s starting from indices[i] and up to
 * (but not including) the next '#' character is equal to words[i].
 * Given an array of words, return the length of the shortest reference string s possible of any valid encoding of words.
 */
public class LeetCode820 {

    public static void main(String[] args) {
        System.out.println(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(minimumLengthEncoding(new String[]{"me", "time"}));
        System.out.println(minimumLengthEncoding(new String[]{"t"}));
        System.out.println(minimumLengthEncoding(new String[]{"time", "atime", "btime"}));
    }

    public static int minimumLengthEncoding(String[] words) {
        Set<String> hash = new HashSet<>();
        int ans = 0;
        Arrays.sort(words, (o1, o2) -> -Integer.compare(o1.length(), o2.length()));
        for (String word : words) {
            if (!hash.contains(word)) {
                ans += word.length() + 1;
                populateHash(word, hash);
            }
        }
        return ans;
    }

    private static void populateHash(String word, Set<String> hash) {
        while (word.length() > 0) {
            hash.add(word);
            word = word.substring(1);
        }
    }
}