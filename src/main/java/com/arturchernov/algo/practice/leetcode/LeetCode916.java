package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 916. Word Subsets
 * <p>
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 * <p>
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.
 * For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 * <p>
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 * <p>
 * Return a list of all universal words in A.  You can return the words in any order.
 */
public class LeetCode916 {

    public static void main(String[] args) {
        System.out.println(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "o"}));
        System.out.println(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"l", "e"}));
        System.out.println(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"e", "oo"}));
        System.out.println(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"lo", "eo"}));
        System.out.println(wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[]{"ec", "oc", "ceo"}));
    }

    public static List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans = new ArrayList<>();
        int[] resB = new int[26];
        for (int i = 0; i < B.length; i++) {
            mergeMax(resB, getTotal(B[i]));
        }
        for (int i = 0; i < A.length; i++) {
            if (check(resB, getTotal(A[i]))) {
                ans.add(A[i]);
            }
        }
        return ans;
    }

    private static int[] getTotal(String s) {
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        return a;
    }

    private static void mergeMax(int[] res, int[] b) {
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(res[i], b[i]);
        }
    }

    private static boolean check(int[] res, int[] b) {
        for (int i = 0; i < res.length; i++) {
            if (b[i] < res[i]) {
                return false;
            }
        }
        return true;
    }
}