package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * <p>
 * A decimal number is called deci-binary if each of its digits is either 0 or 1 without any leading zeros.
 * For example, 101 and 1100 are deci-binary, while 112 and 3001 are not.
 * <p>
 * Given a string n that represents a positive decimal integer,
 * return the minimum number of positive deci-binary numbers needed so that they sum up to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = "32"
 * Output: 3
 * Explanation: 10 + 11 + 11 = 32
 * Example 2:
 * <p>
 * Input: n = "82734"
 * Output: 8
 * Example 3:
 * <p>
 * Input: n = "27346209830709182346"
 * Output: 9
 * <p>
 * Constraints:
 * <p>
 * 1 <= n.length <= 105
 * n consists of only digits.
 * n does not contain any leading zeros and represents a positive integer.
 */
public class LeetCode1689 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode1689()).start();
    }

    @Override
    public void run() {
        System.out.println(minPartitions("32"));
        System.out.println(minPartitions("82734"));
        System.out.println(minPartitions("27346209830709182346"));
    }

    public int minPartitions(String n) {
        char max = '0';
        for (char ch : n.toCharArray()) {
            if (ch > max) {
                max = ch;
            }
        }
        return max - '0';
    }
}
