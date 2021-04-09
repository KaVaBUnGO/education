package com.arturchernov.algo.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 17. Letter Combinations of a Phone Number
 * <p>
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LeetCode17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
    }

    private static final String[] mapping = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return Collections.emptyList();
        }
        List<String> ans = new ArrayList<>();
        getAns(digits, 0, "", ans);
        return ans;
    }

    private static void getAns(String input, int iter, String res, List<String> ans) {
        if (iter == input.length()) {
            ans.add(res);
            return;
        }
        String letters = getLetters(input.charAt(iter));
        for (int i = 0; i < letters.length(); i++) {
            getAns(input, iter + 1, res + letters.charAt(i), ans);
        }
    }

    private static String getLetters(int num) {
        return mapping[num - '2'];
    }

}