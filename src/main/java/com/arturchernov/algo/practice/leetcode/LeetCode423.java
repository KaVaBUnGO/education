package com.arturchernov.algo.practice.leetcode;

/**
 * @author Artur Chernov
 * <p>
 * LeetCode 423. Reconstruct Original Digits from English
 * <p>
 * Given a non-empty string containing an out-of-order English representation of digits 0-9,
 * output the digits in ascending order.
 * <p>
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 */
public class LeetCode423 {

    public static void main(String[] args) {
        System.out.println(originalDigits("zeroonetwothreefourfivesixseveneightnine"));
        System.out.println(originalDigits("zerozero"));
        System.out.println(originalDigits("owoztneoer"));
        System.out.println(originalDigits("fviefuro"));
    }

    public static String originalDigits(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int[] countAns = new int[10];
        countAns[0] = count['z' - 'a'];
        countAns[2] = count['w' - 'a'];
        countAns[4] = count['u' - 'a'];
        countAns[6] = count['x' - 'a'];
        countAns[8] = count['g' - 'a'];
        countAns[5] = count['f' - 'a'] - countAns[4];
        countAns[7] = count['v' - 'a'] - countAns[5];
        countAns[9] = count['i' - 'a'] - countAns[6] - countAns[5] - countAns[8];
        countAns[3] = count['h' - 'a'] - countAns[8];
        countAns[1] = count['o' - 'a'] - countAns[2] - countAns[4] - countAns[0];
        for (int i = 0; i < 10; i++) {
            sb.append(String.valueOf(i).repeat(countAns[i]));
        }
        return sb.toString();
    }
}