package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 784. Letter Case Permutation
 * <p>
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 * <p>
 * Return a list of all possible strings we could create. You can return the output in any order.
 */
public class LeetCode784 {

    public static void main(String[] args) {
        System.out.println(letterCasePermutation("a1b2"));
        System.out.println(letterCasePermutation("3z4"));
        System.out.println(letterCasePermutation("12345"));
        System.out.println(letterCasePermutation("0"));
    }

    public static List<String> letterCasePermutation(String S) {
        S = S.toLowerCase();
        List<String> ans = new ArrayList<>();
        int countLetters = 0;
        for (Character ch : S.toCharArray()) {
            if (Character.isLetter(ch)) {
                ++countLetters;
            }
        }
        for (int i = 0; i < Math.pow(2, countLetters); i++) {
            String binaryString = Integer.toBinaryString(i);
            StringBuilder sb = new StringBuilder();
            int it = binaryString.length() - countLetters;
            for (int j = S.length() - 1; j >= 0; j--) {
                if (Character.isLetter(S.charAt(j))) {
                    if (it >= 0 && binaryString.charAt(it) == '1') {
                        sb.append(Character.toUpperCase(S.charAt(j)));
                    } else {
                        sb.append(S.charAt(j));
                    }
                    ++it;
                } else {
                    sb.append(S.charAt(j));
                }
            }
            ans.add(sb.reverse().toString());
        }
        return ans;
    }
}