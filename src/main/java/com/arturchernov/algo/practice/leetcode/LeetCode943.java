package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 943. Find the Shortest Superstring
 * <p>
 * Given an array of strings words, return the smallest string that contains each string in words as a substring.
 * If there are multiple valid strings of the smallest length, return any of them.
 * <p>
 * You may assume that no string in words is a substring of another string in words.
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["alex","loves","leetcode"]
 * Output: "alexlovesleetcode"
 * Explanation: All permutations of "alex","loves","leetcode" would also be accepted.
 * Example 2:
 * <p>
 * Input: words = ["catg","ctaagt","gcta","ttca","atgcatc"]
 * Output: "gctaagttcatgcatc"
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 12
 * 1 <= words[i].length <= 20
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class LeetCode943 implements Runnable {

    private String[][] lookup;

    public static void main(String[] args) {
        new Thread(new LeetCode943()).start();
    }

    @Override
    public void run() {
        System.out.println(shortestSuperstring(new String[]{"alex", "loves", "leetcode"}));
        System.out.println(shortestSuperstring(new String[]{"catg", "ctaagt", "gcta", "ttca", "atgcatc"}));
    }

    // it is TSP problem
    private String shortestSuperstring(String[] A) {

        String[][] dp = new String[A.length][5000];
        lookup = new String[A.length][A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (i == j) continue;
                int k = 1;
                int idx = 0;
                while (k <= A[j].length()) {
                    if (A[i].endsWith(A[j].substring(0, k)))
                        idx = k;
                    k++;
                }
                lookup[i][j] = A[j].substring(idx, A[j].length());
            }
        }

        String ans = "";
        int minLength = Integer.MAX_VALUE / 2;
        int bitmask = 0;

        for (int i = 0; i < A.length; i++) {
            String tmp = A[i] + superString(A, i, bitmask | (1 << i), dp);
            if (tmp.length() < minLength) {
                minLength = tmp.length();
                ans = tmp;
            }
        }
        return ans;
    }

    private String superString(String[] A, int last, int bitmask, String[][] dp) {
        String res = "";
        int minLength = Integer.MAX_VALUE / 2;
        if (dp[last][bitmask] != null)
            return dp[last][bitmask];

        for (int i = 0; i < A.length; i++) {
            if ((bitmask & (1 << i)) != 0)
                continue;
            String tmp = lookup[last][i] + superString(A, i, bitmask | (1 << i), dp);
            if (tmp.length() < minLength) {
                minLength = tmp.length();
                res = tmp;
            }
        }
        return dp[last][bitmask] = res;
    }
}
