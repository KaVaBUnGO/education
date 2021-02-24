package com.arturchernov.algo.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 856. Score of Parentheses
 * <p>
 * Given a balanced parentheses string S, compute the score of the string based on the following rule:
 * <p>
 * () has score 1
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 */
public class LeetCode856 {

    public static void main(String[] args) {
        System.out.println(scoreOfParentheses("()"));
        System.out.println(scoreOfParentheses("(())"));
        System.out.println(scoreOfParentheses("()()"));
        System.out.println(scoreOfParentheses("(()(()))"));
        System.out.println(scoreOfParentheses("((((((((((((((((((((((((()))))))))))))))))))))))))"));
    }

    public static int scoreOfParentheses(String S) {
        return getSum(new SubStr(0, S.length()), S);
    }

    public static int getSum(SubStr str, String s) {
        int sum = 0;
        Set<SubStr> set = separate(str, s);
        for (SubStr st : set) {
            if (st.r - st.l == 2) {
                sum += 1;
            } else {
                sum += 2 * getSum(new SubStr(st.l + 1, st.r - 1), s);
            }
        }
        return sum;
    }

    public static Set<SubStr> separate(SubStr str, String s) {
        Set<SubStr> ans = new HashSet<>();
        int k = 0;
        int l = 0;
        for (int i = str.l; i < str.r; i++) {
            if (s.charAt(i) == '(') {
                if (k == 0) {
                    l = i;
                }
                ++k;
            } else {
                --k;
                if (k == 0) {
                    ans.add(new SubStr(l, i+1));
                }
            }
        }
        return ans;
    }

    private static class SubStr {
        int l;
        int r;

        public SubStr(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}