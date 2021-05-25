package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 709. To Lower Case
 * <p>
 * Given a string s, return the string after replacing every uppercase letter with the same lowercase letter.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello"
 * Output: "hello"
 * Example 2:
 * <p>
 * Input: s = "here"
 * Output: "here"
 * Example 3:
 * <p>
 * Input: s = "LOVELY"
 * Output: "lovely"
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 100
 * s consists of printable ASCII characters.
 */
public class LeetCode709 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode709()).start();
    }

    @Override
    public void run() {
        System.out.println(toLowerCase("Hello"));
        System.out.println(toLowerCase("here"));
        System.out.println(toLowerCase("LOVELY"));
    }

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }
}
