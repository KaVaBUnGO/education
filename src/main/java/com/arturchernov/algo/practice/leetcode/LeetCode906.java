package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 906. Super Palindromes
 * <p>
 * Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.
 * <p>
 * Given two positive integers left and right represented as strings,
 * return the number of super-palindromes integers in the inclusive range [left, right].
 * <p>
 * Example 1:
 * <p>
 * Input: left = "4", right = "1000"
 * Output: 4
 * Explanation: 4, 9, 121, and 484 are superpalindromes.
 * Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 * Example 2:
 * <p>
 * Input: left = "1", right = "2"
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * 1 <= left.length, right.length <= 18
 * left and right consist of only digits.
 * left and right cannot have leading zeros.
 * left and right represent integers in the range [1, 1018 - 1].
 * left is less than or equal to right.
 */
public class LeetCode906 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode906()).start();
    }

    @Override
    public void run() {
        System.out.println(superpalindromesInRange("1", "999999999999999999"));
    }

    public int superpalindromesInRange(String left, String right) {
        int ans = 0;
        int l = (int) Math.sqrt(Long.parseLong(left));
        int r = (int) Math.sqrt(Long.parseLong(right));
        int p = next(l - 1);
        while (p <= r) {
            if (isPalindrome((long) p * p))
                ++ans;
            p = next(p);
        }
        return ans;
    }

    private int next(int num) {
        char[] s = String.valueOf(num + 1).toCharArray();
        for (int i = 0, n = s.length; i < (n >> 1); i++) {
            while (s[i] != s[n - 1 - i]) {
                increment(s, n - 1 - i);
            }
        }
        return Integer.parseInt(new String(s));
    }

    private void increment(char[] s, int i) {
        while (s[i] == '9') s[i--] = '0';
        s[i]++;
    }

    private boolean isPalindrome(Long a) {
        String s = String.valueOf(a);
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
