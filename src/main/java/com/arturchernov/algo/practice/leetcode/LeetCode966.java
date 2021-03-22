package com.arturchernov.algo.practice.leetcode;

import java.util.*;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 966. Vowel Spellchecker
 * <p>
 * Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
 * <p>
 * For a given query word, the spell checker handles two categories of spelling mistakes:
 * <p>
 * Capitalization: If the query matches a word in the wordlist (case-insensitive),
 * then the query word is returned with the same case as the case in the wordlist.
 * Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
 * Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
 * Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
 * Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with
 * any vowel individually, it matches a word in the wordlist (case-insensitive),
 * then the query word is returned with the same case as the match in the wordlist.
 * Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
 * Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
 * Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
 * In addition, the spell checker operates under the following precedence rules:
 * <p>
 * When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
 * When the query matches a word up to capitlization, you should return the first such match in the wordlist.
 * When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
 * If the query has no matches in the wordlist, you should return the empty string.
 * Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].
 */
public class LeetCode966 {

    public static void main(String[] args) {
        String[] answers = spellchecker(
                new String[]{"KiTe", "kite", "hare", "Hare"},
                new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"}
        );
        System.out.println(String.join(", ", answers));
    }

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> words = new HashSet<>(Arrays.asList(wordlist));
        Map<String, String> patterns = new HashMap<>();
        Map<String, String> lowerCases = new HashMap<>();

        for (String word : wordlist) {
            String lower = word.toLowerCase();
            lowerCases.putIfAbsent(lower, word);
            patterns.putIfAbsent(pattern(lower), word);
        }

        int it = 0;
        for (String s : queries) {
            String lower = s.toLowerCase();
            String pattern = pattern(lower);
            if (words.contains(s)) {
                queries[it++] = s;
            } else if (lowerCases.containsKey(lower)) {
                queries[it++] = lowerCases.get(lower);
            } else {
                queries[it++] = patterns.getOrDefault(pattern, "");
            }
        }
        return queries;
    }

    public static String pattern(String s) {
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            if (chars[i] == 'a' || chars[i] == 'o' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'u'){
                chars[i] = 0;
            }
        }
        return Arrays.toString(chars);
    }

}