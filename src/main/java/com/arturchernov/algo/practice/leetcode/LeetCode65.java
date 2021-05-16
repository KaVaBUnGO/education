package com.arturchernov.algo.practice.leetcode;

import java.util.Arrays;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 65. Valid Number
 * <p>
 * A valid number can be split up into these components (in order):
 * <p>
 * A decimal number or an integer.
 * (Optional) An 'e' or 'E', followed by an integer.
 * A decimal number can be split up into these components (in order):
 * <p>
 * (Optional) A sign character (either '+' or '-').
 * One of the following formats:
 * At least one digit, followed by a dot '.'.
 * At least one digit, followed by a dot '.', followed by at least one digit.
 * A dot '.', followed by at least one digit.
 * An integer can be split up into these components (in order):
 * <p>
 * (Optional) A sign character (either '+' or '-').
 * At least one digit.
 * For example, all the following are valid numbers:
 * ["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"],
 * while the following are not valid numbers: ["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"].
 * <p>
 * Given a string s, return true if s is a valid number.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "0"
 * Output: true
 * Example 2:
 * <p>
 * Input: s = "e"
 * Output: false
 * Example 3:
 * <p>
 * Input: s = "."
 * Output: false
 * Example 4:
 * <p>
 * Input: s = ".1"
 * Output: true
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 20
 * s consists of only English letters (both uppercase and lowercase), digits (0-9), plus '+', minus '-', or dot '.'.
 */
public class LeetCode65 implements Runnable {

    public static void main(String[] args) {
        new Thread(new LeetCode65()).start();
    }

    @Override
    public void run() {
        String[] validNums = new String[]{"2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3",
                "3e+7", "+6e-1", "53.5e93", "-123.456e789"};
        String[] invalidNums = new String[]{"abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"};
        System.out.println("Valid:");
        Arrays.stream(validNums).forEach(num -> System.out.println(isNumber(num)));
        System.out.println();
        System.out.println("Invalid:");
        Arrays.stream(invalidNums).forEach(num -> System.out.println(isNumber(num)));

    }

    public boolean isNumber(String s) {
        String src = s.toLowerCase();
        char[] chars = src.toLowerCase().toCharArray();

        if (isInteger(chars)) {
            return true;
        }

        if (!checkSign(chars)) {
            return false;
        }
        src = removeSigns(src);

        if (!checkExp(src)) {
            return false;
        }
        src = removeExp(src);


        if (!checkDecimal(src)) {
            return false;
        }

        return true;
    }

    private boolean checkDecimal(String s) {
        if (s.length() == 0) return false;
        String[] res = s.split("\\.", -1);
        if (res.length == 1) return isInteger(s.toCharArray());
        if (res.length > 2) return false;
        if (res[0].length() == 0 && isInteger(res[1].toCharArray())) return true;
        if (res[1].length() == 0 && isInteger(res[0].toCharArray())) return true;
        if (isInteger(res[0].toCharArray()) && isInteger(res[1].toCharArray())) return true;
        return false;
    }

    private boolean checkExp(String s) {
        String[] res = s.split("e", -1);
        if (res.length == 1) return true;
        if (res.length > 2) return false;
        return isInteger(res[1].toCharArray());
    }

    private String removeExp(String s) {
        String[] res = s.split("e", -1);
        return res[0];
    }

    private boolean checkSign(char[] chars) {
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char ch = chars[i];
            if ((ch == '+' || ch == '-') && i > 0 && chars[i - 1] != 'e') {
                return false;
            }
        }
        return true;
    }

    private String removeSigns(String s) {
        return s.replace("+", "")
                .replace("-", "");
    }

    private boolean isInteger(char[] chars) {
        if (chars.length == 0) return false;
        for (char ch : chars) {
            if (ch < '0' || ch > '9')
                return false;
        }
        return true;
    }
}
